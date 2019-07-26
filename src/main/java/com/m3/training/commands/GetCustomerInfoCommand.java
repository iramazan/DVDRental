package com.m3.training.commands;

import java.util.List;

import com.m3.training.DAO.GenericDAO;
import com.m3.training.SQLObject.Customer;


public class GetCustomerInfoCommand implements ICommand {
	
	private GenericDAO<Customer> dao;
	private List<Customer> customers; 
	
	public GetCustomerInfoCommand() {
		dao = new GenericDAO<Customer>(Customer.class);
	}
	
	@Override
	public void executes() {
		customers =  dao.getAll();
		customers.forEach(customer ->{customer.toString();});
	}

}
