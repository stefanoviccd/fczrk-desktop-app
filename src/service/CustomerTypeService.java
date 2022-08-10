package service;

import java.sql.SQLException;
import java.util.List;

import model.CustomerType;
import repository.CustomerTypeRepository;
import repository.impl.CustomerTypeRepositoryImpl;

public interface CustomerTypeService {
	
	public List<CustomerType> getCustomerTypes() throws SQLException;


}
