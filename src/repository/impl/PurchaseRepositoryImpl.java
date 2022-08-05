package repository.impl;

import java.sql.Statement;

import db.DBConnection;
import repository.PurchaseRepository;

public class PurchaseRepositoryImpl implements PurchaseRepository {
	
	@Override
	public void deleteByCustomerId(int customerId) throws Exception {
		
		Statement statement = DBConnection.getInstance().getConnection().createStatement();
		String query = "DELETE FROM PURCHASE WHERE customer_id= '" + customerId + "'";
		int rowAffected = statement.executeUpdate(query);
		
		if(rowAffected<=0) {
			throw new Exception("Ne postoje kupovine korisnika sa id-em"+customerId);
		}   
		statement.close();
		
		
	}


	
}

