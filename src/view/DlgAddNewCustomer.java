package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import java.util.regex.*;

public class DlgAddNewCustomer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFullName;
	private JTextField txtContact;
	private JTextField txtTotalBill;
	private UIController uiController;
	private FrmMain mainForm;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public DlgAddNewCustomer(final FrmMain frmMain) throws Exception {
		uiController=new UIController();
		setAlwaysOnTop(true);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ime i prezime:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(68, 39, 102, 13);
		contentPanel.add(lblNewLabel);
		
		txtFullName = new JTextField();
		txtFullName.setBounds(180, 37, 173, 19);
		contentPanel.add(txtFullName);
		txtFullName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Kontakt:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(68, 80, 45, 13);
		contentPanel.add(lblNewLabel_1);
		
		txtContact = new JTextField();
		txtContact.setBounds(180, 77, 173, 19);
		contentPanel.add(txtContact);
		txtContact.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ukupni ra\u010Dun:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(68, 120, 102, 13);
		contentPanel.add(lblNewLabel_1_1);
		
		txtTotalBill = new JTextField();
		txtTotalBill.setColumns(10);
		txtTotalBill.setBounds(180, 117, 173, 19);
		contentPanel.add(txtTotalBill);
		
		JLabel lblNewLabel_2 = new JLabel("Tip korisnika:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(68, 157, 113, 13);
		contentPanel.add(lblNewLabel_2);
		
		final JComboBox<CustomerType> comboBoxCustomerType = new JComboBox<CustomerType>(); 
		List<CustomerType> customerTypes = new ArrayList<>();
		try {
			customerTypes = uiController.getCustomerTypes();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		int sizeOfCustomerTypes = customerTypes.size();
		comboBoxCustomerType.setModel(new DefaultComboBoxModel<CustomerType>());
		for (int i = 0; i < sizeOfCustomerTypes; i++) {
			comboBoxCustomerType.addItem(customerTypes.get(i));
		}
		comboBoxCustomerType.setBounds(180, 154, 173, 21);
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
							validateForm();
							String fullName = txtFullName.getText().trim();
							String contact = txtContact.getText().trim();
							double totalBill = Double.parseDouble(txtTotalBill.getText());
							CustomerType customerType = (CustomerType) comboBoxCustomerType.getSelectedItem();
							uiController.addNewCustomer(fullName,contact, totalBill, customerType);
							frmMain.refreshTable();
							JOptionPane.showMessageDialog(getRootPane(), "Uspe�no evidentiran majstor.", "", JOptionPane.DEFAULT_OPTION);
							dispose();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(getRootPane(), ex.getMessage(), "Gre�ka", JOptionPane.ERROR_MESSAGE);	
						}
					}

					private void validateForm() throws Exception {
						String fullName = txtFullName.getText().trim();
						String contact = txtContact.getText().trim();
						double totalBill = Double.parseDouble(txtTotalBill.getText());
						CustomerType customerType = (CustomerType) comboBoxCustomerType.getSelectedItem();
						if(fullName==null || fullName.isEmpty())
							throw new Exception("Morate uneti vrednost za ime i prezime!");
						if(totalBill < 0)
							throw new Exception("Morate uneti pozitivu vrednost za ukupni racun!");
						if(!isContactValid(contact))
							throw new Exception("Morate uneti kontakt u pravom formatu!");
						if(customerType==null) 
							throw new Exception("Morate izabrati tip!");
					}

					private boolean isContactValid(String contact) {
						
						Pattern ptrn = Pattern.compile("^06[012345689][0-9]{6,7}$");
						Matcher match = ptrn.matcher(contact);
						return (match.find() && match.group().equals(contact));
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
