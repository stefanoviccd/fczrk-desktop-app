package repository;

import java.sql.SQLException;
import java.util.List;

import model.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();

	void addNewCustomer(Customer customer);

	List<Customer> findByContact(String contact) throws SQLException;


}
