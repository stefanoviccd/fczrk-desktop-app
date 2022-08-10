package repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import model.Customer;
import model.CustomerType;
import model.CustomerTypeName;
import repository.CustomerTypeRepository;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {

	@Override
	public List<CustomerType> getCustomerTypes() throws SQLException {
		Statement statement = DBConnection.getInstance().getConnection().createStatement();
		String query = "SELECT * FROM CUSTOMER_TYPE";
		ResultSet rs = statement.executeQuery(query);
		List<CustomerType> customerTypes = new ArrayList<>();
		
		while(rs.next()) {
			CustomerType customerType = new CustomerType();
			
			customerType.setTypeId(rs.getLong("id"));
			customerType.setType(CustomerTypeName.valueOf(rs.getString("customer_type_name")));
			customerType.setDiscount(rs.getDouble("discount"));
			customerType.setThreshold(rs.getDouble("threshold"));
			customerTypes.add(customerType);
		}
		statement.close();
		rs.close();
		return customerTypes;
	}

}
