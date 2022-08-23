package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.CustomerType;
import service.CustomerService;
import service.CustomerTypeService;
import service.impl.CustomerServiceImpl;
import service.impl.CustomerTypeServiceImpl;

public class Controller {
	CustomerService customerService;
	CustomerTypeService customerTypeService;
	public Controller() {
		customerService=new CustomerServiceImpl();
		customerTypeService = new CustomerTypeServiceImpl();
	}
	public List<Customer> getAllCustomers() throws Exception {
		try {
			return customerService.getAllCustomers();
		} catch (Exception e) {
			throw e;
		}
	}
	public void addNewCustomer(Customer customer) throws Exception {
		try {
			customerService.addNewCustomer(customer);
		} catch (Exception e) {
			throw e;
		}
		
		
	}
	public List<CustomerType> getCustomerTypes() throws SQLException {
		try {
			return customerTypeService.getCustomerTypes();
		} catch (SQLException e) {
			throw e;
		}
	}

}
