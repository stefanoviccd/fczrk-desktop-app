package service.impl;

import java.sql.SQLException;
import java.util.List;

import db.DBConnection;
import model.Customer;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository;
	public CustomerServiceImpl() {
		customerRepository=new CustomerRepositoryImpl();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	@Override
	public void addNewCustomer(Customer customer) throws SQLException {
		try {
			DBConnection.getInstance().connect();
			List<Customer> customers = customerRepository.findByContact(customer.getContact());
			if(!customers.isEmpty()) throw new Exception("Korisnik sa brojem telefona postoji");
			customerRepository.addNewCustomer(customer);
			DBConnection.getInstance().commit();
		} catch (Exception e) {
			DBConnection.getInstance().rollback();
		} finally {
			DBConnection.getInstance().disconnect();
		}
		
	}



}
