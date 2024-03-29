package view.tableModel;
import model.Customer;
import model.CustomerType;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModelCustomer extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Customer> customers;
	String[] columnNames= {"Ime i prezime", "Kontakt", "Ukupni pazar", "Tip korisnika"};
	Class[] columnClasses= {String.class, String.class, double.class, CustomerType.class};
	
	public TableModelCustomer(List<Customer> customers) {
		this.customers=customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
		fireTableDataChanged();
	}
	@Override
	public int getRowCount() {
		if(customers==null)return 0;
		return customers.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Customer customer=customers.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return (String) customer.getFullName();
		case 1:
			return (String) customer.getContact();
		case 2:
			return (double) customer.getTotalBill();
		case 3:
			return (CustomerType) customer.getCustomerType();
		default:  return "n/a";

		}
		
		}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return (Class<?>) columnClasses[columnIndex];
	}
	@Override
	public String getColumnName(int column) {
		
		return columnNames[column];
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	
	
	

}
