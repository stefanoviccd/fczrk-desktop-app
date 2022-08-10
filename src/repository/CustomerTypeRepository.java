package repository;

import java.sql.SQLException;
import java.util.List;

import model.CustomerType;

public interface CustomerTypeRepository {

	List<CustomerType> getCustomerTypes() throws SQLException;

}
