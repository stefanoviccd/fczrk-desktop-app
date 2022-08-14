package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UIController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import model.CustomerType;
import model.CustomerTypeName;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class DlgAddNewCustomer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtContact;
	private JTextField txtTotalBill;
	private UIController uiController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAddNewCustomer dialog = new DlgAddNewCustomer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAddNewCustomer() {
		uiController=new UIController();
		setAlwaysOnTop(true);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIme = new JLabel("Ime:");
			lblIme.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIme.setBounds(20, 20, 81, 20);
			contentPanel.add(lblIme);
		}
		
		txtName = new JTextField();
		txtName.setBounds(132, 22, 173, 19);
		contentPanel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Prezime:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 62, 45, 13);
		contentPanel.add(lblNewLabel);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(132, 60, 173, 19);
		contentPanel.add(txtSurname);
		txtSurname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Kontakt:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 103, 45, 13);
		contentPanel.add(lblNewLabel_1);
		
		txtContact = new JTextField();
		txtContact.setBounds(132, 100, 173, 19);
		contentPanel.add(txtContact);
		txtContact.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ukupni ra\u010Dun:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(20, 143, 102, 13);
		contentPanel.add(lblNewLabel_1_1);
		
		txtTotalBill = new JTextField();
		txtTotalBill.setColumns(10);
		txtTotalBill.setBounds(132, 140, 173, 19);
		contentPanel.add(txtTotalBill);
		
		JLabel lblNewLabel_2 = new JLabel("Tip korisnika:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(20, 180, 113, 13);
		contentPanel.add(lblNewLabel_2);
		
		JComboBox comboBoxCustomerType = new JComboBox(); 
		List<CustomerType> customerTypes= uiController.getCustomerTypes();
		comboBoxCustomerType.setModel(new DefaultComboBoxModel<CustomerType>());
		comboBoxCustomerType.setBounds(132, 177, 173, 21);
		contentPanel.add(comboBoxCustomerType);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Dodaj novog korisnika");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String name = txtName.getText().trim();
							String contact = txtContact.getText().trim();
							double totalBill = Double.parseDouble(txtTotalBill.getText());
							CustomerTypeName customerType = (CustomerTypeName) comboBoxCustomerType.getSelectedItem();
							uiController.addNewCustomer(name,contact, totalBill, customerType);
							JOptionPane.showMessageDialog(getRootPane(), "Uspešno evidentiran majstor.", "", JOptionPane.DEFAULT_OPTION);
							dispose();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(getRootPane(), ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
								
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Poni\u0161ti");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
