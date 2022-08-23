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

	public ArrayList<Customer> getAllCustomers() throws Exception {
		try {
			return (ArrayList<Customer>) controller.getAllCustomers();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void openDlgAddNewCustomer(FrmMain frmMain) throws Exception {
		DlgAddNewCustomer dialog = new DlgAddNewCustomer(frmMain);
		dialog.setVisible(true);
	}

	public void addNewCustomer(String fullName,String contact, double totalBill, CustomerType customerType) throws Exception {
			try {
				Customer customer = new Customer();
				customer.setFullName(fullName);
				customer.setContact(contact);
				customer.setTotalBill(totalBill);
				customer.setCustomerType(customerType);		
				controller.addNewCustomer(customer);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}

	public java.util.List<CustomerType> getCustomerTypes() throws Exception {
		try {
			return controller.getCustomerTypes();
		} catch (Exception e) {
			throw e;
		}
	}

}
