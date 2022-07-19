package model;

import java.util.Date;
import java.util.LinkedList;

public class Purchase {

	private Long id;
	private Date dateTime;
	private Double amount;
	private Boolean paid;
	private Customer customer;
	private LinkedList<PurchaseItem> items;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Boolean getPaid() {
		return paid;
	}
	
	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public LinkedList<PurchaseItem> getItems() {
		return items;
	}
	
	public void setItems(LinkedList<PurchaseItem> items) {
		this.items = items;
	}
	
	
}
