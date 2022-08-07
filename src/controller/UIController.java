package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Customer;
import model.CustomerType;
import model.CustomerTypeName;
import view.DlgAddNewCustomer;
import view.FrmMain;

public class UIController {
	private Controller controller;
	public UIController() {
		controller=new Controller();
	}

	public ArrayList<Customer> getAllCustomers() {
		return (ArrayList<Customer>) controller.getAllCustomers();
	}

	public void openDlgAddNewCustomer(FrmMain frmMain) {
		DlgAddNewCustomer dialog = new DlgAddNewCustomer(frmMain);
		dialog.setVisible(true);
	}

	public void addNewCustomer(String fullName,String contact, double totalBill, CustomerTypeName customerType) throws Exception {
			try {
				Customer customer = new Customer();
				customer.setFullName(fullName);
				customer.setContact(contact);
				customer.setTotalBill(totalBill);
				CustomerType type=new CustomerType();
				type.setType(customerType);
				customer.setCustomerType(type);		
				controller.addNewCustomer(customer);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}

	public java.util.List<CustomerType> getCustomerTypes() {
		try {
			return controller.getCustomerTypes();
		} catch (Exception e) {
			throw e;
		}
	}

}
