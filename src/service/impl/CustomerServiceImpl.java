package service.impl;

import java.util.List;

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

}
