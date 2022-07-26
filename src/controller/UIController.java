package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;
import model.CustomerType;
import view.DlgAddNewCustomer;
import view.FrmMain;

public class UIController {
	static Controller controller;
	public UIController() {
		controller=new Controller();
	}

	public ArrayList<Customer> getAllCustomers() {
		return (ArrayList<Customer>) controller.getAllCustomers();
	}

	public static void openDlgAddNewCustomer() {
		DlgAddNewCustomer dialog = new DlgAddNewCustomer();
		dialog.setVisible(true);
	}

	public static void addNewCustomer(String name, String surname, String contact, double totalBill, CustomerType customerType) {
			try {
				Customer customer = new Customer();
				
				customer.setName(name);
				customer.setSurname(surname);
				customer.setContact(contact);
				customer.setTotalBill(totalBill);
				customer.setCustomerType(customerType);
				
				controller.addNewCustomer(customer);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
