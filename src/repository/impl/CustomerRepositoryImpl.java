package repository.impl;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import repository.CustomerRepository;

public class CustomerRepositoryImpl implements CustomerRepository {
	List<Customer> customers;
	public CustomerRepositoryImpl() {
		customers = new ArrayList<>();
		Customer c=new Customer();
		c.setName("Pera");
		c.setSurname("Petrovic");
		c.setContact("0640555969");
		c.setTotalBill(12000);
		customers.add(c);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}

}
