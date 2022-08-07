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
import model.CustomerTypeName;
import repository.CustomerRepository;

public class CustomerRepositoryImpl implements CustomerRepository {
	
	public CustomerRepositoryImpl() {
	}

	@Override
	public List<Customer> getAllCustomers() {
		//return customers;
		return null;
	}
	//todo: da bismo mogli da dodamo id za tip korisnika kao spoljnji kljuc, prethodno je potrebno da nadjemo u bazi 
	//tip korisnika sa prosledjenim nazivom, i da uzmemo njegov id. Zatim taj id ubacujemo kao spoljnji kljuc
	//naseg majstora
	@Override
	public void addNewCustomer(Customer customer) throws Exception {
		Statement statement = DBConnection.getInstance().getConnection().createStatement();
			String query = "INSERT INTO CUSTOMER (full_name, contact, total_amount_spent, customer_type_id)" +
					"VALUES ('" + customer.getFullName() + "', '" + customer.getContact() + "', " + customer.getTotalBill() + ", "
					+ customer.getCustomerType().getTypeId() + ")";
			// to sam zaboravila da vam kazem, ukoliko se MENJA nesto u bazi, dakle nije samo citanje podataka u pitanju,
			//ne moze da se koristi execute query, vec executeUpdate.
			statement.executeUpdate(query); // ova metoda vraca id clana koji je ubacen
			statement.close();
	}

	@Override
	public List<Customer> findByContact(String contact) throws SQLException {
		Statement statement = DBConnection.getInstance().getConnection().createStatement();
		String query = "SELECT * FROM CUSTOMER WHERE contact = '" + contact + "'";
		ResultSet rs = statement.executeQuery(query);
		List<Customer> customers = new ArrayList<>();
		
		while(rs.next()) {
			Customer customer = new Customer();
			
			customer.setFullName(rs.getString("full_name"));
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
