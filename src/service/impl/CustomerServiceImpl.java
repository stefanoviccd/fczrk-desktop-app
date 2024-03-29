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
	public List<Customer> getAllCustomers() throws Exception {
		try {
			return customerRepository.getAllCustomers();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	//todo: kod dodavanja korisnika, ukoliko se uhvati izuzetak, potrebno ga je proslediti dalje, sve do forme, na kojoj
	//cemo ako se desi izuzetak prijakazti JoptionPane sa odgovarajucom porukom.
	//(ovo bi znacilo nakon rollback bacamo izuzetak)
	@Override
	public void addNewCustomer(Customer customer) throws Exception {
		try {
			DBConnection.getInstance().connect();
			List<Customer> customers = customerRepository.findByContact(customer.getContact());
			if(!customers.isEmpty()) throw new Exception("Korisnik sa brojem telefona postoji");
			customerRepository.addNewCustomer(customer);
			DBConnection.getInstance().commit();
			DBConnection.getInstance().disconnect();
		} catch (Exception e) {
			DBConnection.getInstance().rollback();
			DBConnection.getInstance().disconnect();
			e.printStackTrace();
			throw e;
		}
		
	}



}
