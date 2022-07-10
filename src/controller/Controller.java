package controller;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

public class Controller {
	CustomerService customerService;
	public Controller() {
		customerService=new CustomerServiceImpl();
	}
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

}
