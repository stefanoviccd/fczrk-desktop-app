package service.impl;

import java.sql.SQLException;
import java.util.List;

import db.DBConnection;
import model.Customer;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import repository.impl.PurchaseRepositoryImpl;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository;
	private PurchaseRepositoryImpl purchaseRepository;
	public CustomerServiceImpl() {
		customerRepository=new CustomerRepositoryImpl();
		purchaseRepository= new PurchaseRepositoryImpl();
	}


	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	@Override
	public boolean deleteCustomer(int customerId) throws SQLException {
		try {
			DBConnection.getInstance().connect();
		    customerRepository.deleteById(customerId);
		    purchaseRepository.deleteByCustomerId(customerId);
			DBConnection.getInstance().commit();
		} catch (Exception e) {
			DBConnection.getInstance().rollback();
			return false;
		
		} finally {
			DBConnection.getInstance().disconnect();
		}
		return true;
	}


}
