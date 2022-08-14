package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.UIController;
import model.Customer;
import model.CustomerType;
import view.tableModel.TableModelCustomer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class FrmMain extends JFrame {


	private JPanel contentPane;
	UIController uiController;
	private JButton btnAddNewCustomer;
	private JButton btnDelete;
	private JButton btnDetails;
	private JTable tblCustomers;
	private JScrollPane scrollPane;
	private Customer selectedCustomer;
	private int selectedRow;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public FrmMain() {
		uiController=new UIController();
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnAddNewCustomer = new JButton("Dodaj novog korisnika");
		btnAddNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uiController.openDlgAddNewCustomer();
			}
		});
		
		btnDelete = new JButton("Izbri\u0161i");
		
		btnDetails = new JButton("Detalji");
		
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					uiController.openFrmUpdate(selectedCustomer);					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(getRootPane(), ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAddNewCustomer, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDetails, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAddNewCustomer, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDetails, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
		tblCustomers = new JTable();
		tblCustomers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = tblCustomers.getSelectedRow();
				TableModelCustomer model = (TableModelCustomer)tblCustomers.getModel();
				selectedCustomer = new Customer();
				selectedCustomer.setFullName((String)model.getValueAt(selectedRow,0));
				selectedCustomer.setContact((String)model.getValueAt(selectedRow, 1));
				selectedCustomer.setTotalBill((Double)model.getValueAt(selectedRow, 2));
				selectedCustomer.setCustomerType((CustomerType)model.getValueAt(selectedRow, 3));
			}
		});
		scrollPane.setViewportView(tblCustomers);
		tblCustomers.setColumnSelectionAllowed(true);
		contentPane.setLayout(gl_contentPane);
		prepareView();
		
	}

	private void prepareView() {
		ArrayList<Customer> customers=uiController.getAllCustomers();
		TableModelCustomer tableModelCustomers=new TableModelCustomer(customers);
		tblCustomers.setModel(tableModelCustomers);
		System.out.println(customers);

		
	}
}
