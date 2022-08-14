package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.CustomerType;
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
	public void addNewCustomer(Customer customer) throws Exception {
		try {
			customerService.addNewCustomer(customer);
		} catch (Exception e) {
			throw e;
		}
		
		
	}
	public List<CustomerType> getCustomerTypes() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}
	
	public void updateCustomer(Customer customer, String contact) throws Exception {
		customerService.updateCustomer(customer,contact);
	}

}
