package repository;

public interface PurchaseRepository {

	public void deleteByCustomerId(int customerId) throws Exception;
}
