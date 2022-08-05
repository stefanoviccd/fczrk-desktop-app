package repository;

import java.util.List;

import model.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();

	void deleteById(int customerId) throws Exception;

}
