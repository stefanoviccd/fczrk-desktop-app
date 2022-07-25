package repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
	public void addNewCustomer(Customer customer) {
			String query = "INSERT INTO CUSTOMER (full_name, contact, total_amount_spent, customer_type_id" +
					"VALUES ('" + customer.getName() + " " + customer.getSurname() + "', '" + customer.getContact() + "', " + customer.getTotalBill() + ", "
					+ customer.getCustomerType() + ")";
		
		
	}

	@Override
	public List<Customer> findByContact(String contact) throws SQLException {
		Statement statement = DBConnection.getInstance().getConnection().createStatement();
		String query = "SELECT * FROM CUSTOMER WHERE contact = '" + contact + "'";
		ResultSet rs = statement.executeQuery(query);
		List<Customer> customers = new ArrayList<>();
		while(rs.next()) {
			Customer customer = new Customer();
			
			customer.setName(rs.getString("full_name"));
			customer.setContact(rs.getString("contact"));
			customer.setTotalBill(rs.getDouble("total_amount_spent"));
			customer.setCustomerType(null);
			
			
			customers.add(customer);
		}
		statement.close();
		rs.close();
		return customers;
	}


}
