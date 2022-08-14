package service;
import java.sql.SQLException;
import java.util.List;

import model.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	
	public void addNewCustomer(Customer customer) throws SQLException, Exception;

	public void updateCustomer(Customer customer, String contact) throws SQLException, Exception;

}
