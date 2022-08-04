package model;

public class Product {
	private Long productId;
	private Long code;
	private Double price;
	private String name;
	private UnitType unit;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getCode() {
		return code;
	}
	
	public void setCode(Long code) {
		this.code = code;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public UnitType getUnit() {
		return unit;
	}
	
	public void setUnit(UnitType unit) {
		this.unit = unit;
	}
	
	
}
