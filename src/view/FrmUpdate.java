package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UIController;
import model.Customer;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FrmUpdate extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtContact;
	private static Customer customer;
	private String oldContact;
	private UIController controller;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmUpdate dialog = new FrmUpdate(customer);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmUpdate(Customer c) {
		controller = new UIController();
		customer = c;
		oldContact = customer.getContact();
		setBounds(100, 100, 278, 289);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(41, 54, 172, 20);
		txtName.setText(customer.getFullName());
		contentPanel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ime i prezime");
		lblNewLabel.setBounds(41, 29, 91, 14);
		contentPanel.add(lblNewLabel);
		
		txtContact = new JTextField();
		txtContact.setBounds(41, 120, 172, 20);
		txtContact.setText(customer.getContact());
		contentPanel.add(txtContact);
		txtContact.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Kontakt");
		lblNewLabel_1.setBounds(41, 97, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JButton btnUpdateCustomer = new JButton("Azuriraj");
		btnUpdateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtName.getText().trim()==null || txtContact.getText().trim()==null) {
						throw new Exception("Niste popunili sva polja.");
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				customer.setFullName(txtName.getText().trim());
				customer.setContact(txtContact.getText().trim());
				try {
					controller.updateCustomer(customer,oldContact);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdateCustomer.setBounds(41, 173, 172, 23);
		contentPanel.add(btnUpdateCustomer);
	}
}
