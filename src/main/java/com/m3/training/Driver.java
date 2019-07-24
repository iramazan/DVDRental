package com.m3.training;

import java.io.IOException;
import java.util.Scanner;

public class Driver {
	
	private Scanner scanner;

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
				case 1: //TODO looking some one information
				case 2: //TODO report film still check out, who are late, fees
				case 3: //TODO what is due tomorrow
				case 4: //TODO most popular movie
				case 5: //TODO most popular categories
				case 6: //TODO employee information
				case 7: //TODO SEarching movie database
				default : 
					continue;
			}
		}
	}
}

