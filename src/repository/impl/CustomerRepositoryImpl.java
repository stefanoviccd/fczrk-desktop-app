package repository.impl;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
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

	@Override
	public void deleteById(int customerId) throws Exception {
		
		Statement statement = DBConnection.getInstance().getConnection().createStatement();
		String query = "DELETE FROM CUSTOMER WHERE id= '" + customerId + "'";
		int rowAffected = statement.executeUpdate(query);
		
		if(rowAffected<=0) {
			throw new Exception("Neuspesno brisanje korisnika sa id-em"+customerId);
		}
		statement.close();
		
	
}


}
