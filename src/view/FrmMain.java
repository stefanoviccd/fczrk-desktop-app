package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.tableModel.TableModelCustomer;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.UIController;
import model.Customer;
import model.CustomerType;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class FrmMain extends JFrame {

	private JPanel contentPane;
	private JTable tblCustomers;
	private JButton btnDetails;
	private JButton btnDelete;
	UIController uiController;



	/**
	 * Create the frame.
	 */
	public FrmMain() {
		uiController=new UIController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tblCustomers = new JTable();
		tblCustomers.setColumnSelectionAllowed(true);
		tblCustomers.setBounds(32, 34, 618, 149);
		
		contentPane.add(tblCustomers);
		
		JButton btnAddNewCustomer = new JButton("Dodaj novog korisnika");
		btnAddNewCustomer.setBounds(695, 23, 178, 37);
		contentPane.add(btnAddNewCustomer);
		
		btnDetails = new JButton("Detalji");
		btnDetails.setBounds(695, 83, 178, 37);
		contentPane.add(btnDetails);
		
		btnDelete = new JButton("Izbri\u0161i");
		btnDelete.setBounds(695, 146, 178, 37);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 378, 455, -179);
		contentPane.add(scrollPane);
		prepareView();
	}



	private void prepareView() {
		ArrayList<Customer> customers=uiController.getAllCustomers();
		TableModelCustomer tableModelCustomers=new TableModelCustomer(customers);
		tblCustomers.setModel(tableModelCustomers);
		System.out.println(customers);

		
	}
}
