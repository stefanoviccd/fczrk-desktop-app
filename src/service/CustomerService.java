package service;
import java.sql.SQLException;
import java.util.List;

import model.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers() throws Exception;
	
	public void addNewCustomer(Customer customer) throws SQLException, Exception;

}
