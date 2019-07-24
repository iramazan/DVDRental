package com.m3.training;

import java.util.List;
import java.util.Scanner;

import com.m3.training.DAO.GenericDAO;
import com.m3.training.SQLObject.Customer;
import com.m3.training.SQLObject.Film;


public class Driver {
	
	private Scanner scanner;
	private GenericDAO<Customer> customerDAO;
	private GenericDAO<Film> filmDAO;
	
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.select();
	}
	
	private void select() {
		System.out.print("Choose ");
		scanner = new Scanner(System.in);
		while(true) {
			int select = scanner.nextInt();
			switch(select) {
				case 0:
					break;
				case 1: 
					getCustomerInfo();
					break;
				case 2: //TODO report film still check out, who are late, fees
				case 3: //TODO what is due tomorrow
				case 4: //TODO most popular movie
				case 5: //TODO most popular categories
				case 6: //TODO employee information
				case 7:
					getMovies();
					break;
				default : 
					continue;
			}
		}
	}
	
	private void getCustomerInfo() {
		customerDAO = new GenericDAO<Customer>(Customer.class);
		List<Customer>customers = customerDAO.getAll();
		customers.forEach(System.out::println);
	}
	
	private void getMovies() {
		filmDAO = new GenericDAO<Film>(Film.class);
		System.out.println("1 : name\n"
				+ "2 : year\n"
				+ "3 : actor\n"
				+ "4 : description\n");
		List<Film> films;
		String value;
		endLoop: while(true) {
			int select = scanner.nextInt();
			System.out.println("Enter value");
			value = scanner.nextLine();
			switch(select) {
				case 1: 
					films = filmDAO.getForParam("name", value);
					break endLoop;
				case 2:
					films = filmDAO.getForParam("year", value);
					break endLoop;
				case 3: 
					films = filmDAO.getForParam("actor", value);
					break endLoop;
				case 4: 
					films = filmDAO.getForParam("description", value);
					break endLoop;
				default : 
					System.out.println("please choose 1 to 5");
					continue;
			}
		}
		films.forEach(System.out::println);
	}
}

