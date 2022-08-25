package service.impl;

import java.sql.SQLException;
import java.util.List;

import model.CustomerType;
import repository.CustomerRepository;
import repository.CustomerTypeRepository;
import repository.impl.CustomerRepositoryImpl;
import repository.impl.CustomerTypeRepositoryImpl;
import service.CustomerTypeService;

public class CustomerTypeServiceImpl implements CustomerTypeService {
	
	private CustomerTypeRepository customerTypeRepository;
	public CustomerTypeServiceImpl() {
		customerTypeRepository=new CustomerTypeRepositoryImpl();
	}
	@Override
	public List<CustomerType> getCustomerTypes() throws SQLException {
			try {
				return customerTypeRepository.getCustomerTypes();
			} catch (SQLException e) {
				throw e;
			}

	}



}
