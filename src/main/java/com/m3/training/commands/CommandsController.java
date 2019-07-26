package com.m3.training.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandsController {
	Map<String, ICommand> controller;
	public CommandsController() {
		controller = new HashMap<String, ICommand>();
		GetCustomerInfoCommand getCustomerInfo = new GetCustomerInfoCommand();
		controller.put("Costumer Information", getCustomerInfo);
	}
	
	public void addCommand(String key, ICommand command) {
		this.controller.put(key, command);
	}
	
	public void execute(String command) {
		this.controller.get(command).executes();
	}
}
