package com.m3.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.m3.training.DAO.GenericDAO;
import com.m3.training.SQLObject.Actor;
import com.m3.training.SQLObject.Customer;
import com.m3.training.SQLObject.Film;
import com.m3.training.SQLObject.Rental;


public class Driver {
	
	private Scanner scanner;
	private GenericDAO<Customer> customerDAO;
	private GenericDAO<Rental> rentalDAO;
	private GenericDAO<Film> filmDAO = new GenericDAO<Film>(Film.class);
	private GenericDAO<Actor> actorDAO  = new GenericDAO<Actor>(Actor.class);
	
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.select();
	}
	
	private void select() {
		scanner = new Scanner(System.in);
		endLoop: while(true) {
			System.out.print("Choose ");
			int select = scanner.nextInt();
			switch(select) {
				case 0:
					break endLoop;
				case 1: 
					getCustomerInfo();
					break;
				case 2: //TODO report film still check out, who are late, fees
					break;
				case 3: //TODO what is due tomorrow
					break;
				case 4: //TODO most popular movie
					break;
				case 5: //TODO most popular categories
					break;
				case 6: //TODO employee information
					break;
				case 7:
					getMovies();
					break;
				default : 
					continue;
			}
		}
	}
	
	private void getCustomerInfo() {
		System.out.println("Enter cutomer's Last Name");
		scanner = new Scanner(System.in);
		String lastName = scanner.nextLine();
		customerDAO = new GenericDAO<Customer>(Customer.class);
		List<Customer> customers = customerDAO.getForParam("lastName", lastName.toUpperCase());
		rentalDAO = new GenericDAO<Rental>(Rental.class);
		Map<Customer, List<Rental>> customerInfo= new HashMap<>();
		customers.forEach(customer -> {customerInfo.put(customer, rentalDAO.getForParam("customerID", customer.getCustomerId()));});
		customerInfo.forEach((key, value) -> {System.out.println(key.toString()); value.forEach(System.out::println);});
	}
	
	private void getMovies() {
		System.out.println("1 : name\n"
				+ "2 : year\n"
				+ "3 : actor\n"
				+ "4 : description\n");
		List<Film> films = new ArrayList<Film>();
		String value;
		endLoop: while(true) {
			int select = scanner.nextInt();
			scanner = new Scanner(System.in);
			System.out.println("Enter value");
			value = scanner.nextLine();
			switch(select) {
				case 1: 
					List<Actor> actors= actorDAO.getForParam("lastName", value);
					for(Actor actor : actors) {
						films.addAll(actor.getFilms());
					}
					break endLoop;
				case 2:
					films = filmDAO.getForParam("releaseYear", value);
					break endLoop;
				case 3: 
					films = filmDAO.getForParam("title", value);
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

