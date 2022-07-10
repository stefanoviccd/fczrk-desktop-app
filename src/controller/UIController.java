package controller;

import java.util.ArrayList;

import model.Customer;

public class UIController {
	Controller controller;
	public UIController() {
		controller=new Controller();
	}

	public ArrayList<Customer> getAllCustomers() {
		return (ArrayList<Customer>) controller.getAllCustomers();
	}

}
