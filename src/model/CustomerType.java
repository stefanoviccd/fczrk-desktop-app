package model;

public class CustomerType {
	private Long typeId;
	private CustomerTypeName type;
	private double threshold;
	private double discount;
	public CustomerTypeName getType() {
		return type;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public void setType(CustomerTypeName type) {
		this.type = type;
	}
	public double getThreshold() {
		return threshold;
	}
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return type.name();
	}
	
}
