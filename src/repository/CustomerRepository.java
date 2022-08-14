package repository;

import java.sql.SQLException;
import java.util.List;

import model.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();

	void addNewCustomer(Customer customer) throws Exception;

	List<Customer> findByContact(String contact) throws Exception;

	void updateCustomer(Customer customer, String contact) throws SQLException;


}
