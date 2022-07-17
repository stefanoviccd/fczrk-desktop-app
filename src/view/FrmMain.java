package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.UIController;
import model.Customer;
import view.tableModel.TableModelCustomer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMain extends JFrame {


	private JPanel contentPane;
	UIController uiController;
	private JButton btnAddNewCustomer;
	private JButton btnDelete;
	private JButton btnDetails;
	private JTable tblCustomers;

	/**
	 * Launch the application.
	 */


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
		
		btnAddNewCustomer = new JButton("Dodaj novog korisnika");
		
		btnDelete = new JButton("Izbri\u0161i");
		
		btnDetails = new JButton("Detalji");
		
		tblCustomers = new JTable();
		tblCustomers.setColumnSelectionAllowed(true);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(tblCustomers, GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddNewCustomer, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDetails, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tblCustomers, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAddNewCustomer, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDetails, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(153, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
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
