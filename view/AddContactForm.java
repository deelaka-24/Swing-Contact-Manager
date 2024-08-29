package view;

import model.Contact;
import model.ContactDBConnection;
import controller.ContactController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

class AddContactForm extends JFrame {
    private JLabel lblTitle;
    private JLabel lblContactId;
    private JLabel lblName;
    private JLabel lblContactNumber;
    private JLabel lblCompany;
    private JLabel lblSalary;
    private JLabel lblBirthday;

    private JTextField txtName;
    private JTextField txtContactNumber;
    private JTextField txtCompany;
    private JTextField txtSalary;
    private JTextField txtBirthday;

    private JButton btnAddContact;
    private JButton btnCancel;
    private JButton btnBack;

    AddContactForm() {
        setSize(400, 450);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel titlePanel = new JPanel(new GridLayout(2, 1));

        lblTitle = new JLabel("ADD CONTACT");
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
        JPanel txtTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtTitlePanel.setBackground(Color.decode("#99cdfd"));
        txtTitlePanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        txtTitlePanel.add(lblTitle);
        titlePanel.add(txtTitlePanel);

        String contactId = ContactController.generateNextContactId();
        lblContactId = new JLabel("Contact ID - " + contactId);
        lblContactId.setHorizontalAlignment(JLabel.LEFT);
        lblContactId.setFont(new Font("SansSerif", Font.BOLD, 20));
        JPanel txtContactIdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtContactIdPanel.setBorder(new EmptyBorder(10, 10, 0, 0));
        txtContactIdPanel.add(lblContactId);
        titlePanel.add(txtContactIdPanel);

        add("North", titlePanel);

        // west panel
        JPanel txtLabelPanel = new JPanel(new GridLayout(5, 1));
        txtLabelPanel.setBorder(new EmptyBorder(0, 20, 0, 0));

        lblName = new JLabel("Name");
        lblContactNumber = new JLabel("Contact Number");
        lblCompany = new JLabel("Company");
        lblSalary = new JLabel("Salary");
        lblBirthday = new JLabel("Birthday");

        JLabel[] labels = { lblName, lblContactNumber, lblCompany, lblSalary, lblBirthday };

        for (JLabel label : labels) {
            label.setFont(new Font("SansSerif", Font.BOLD, 15));
            JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            labelPanel.add(label);
            txtLabelPanel.add(labelPanel);
        }
        add("West", txtLabelPanel);

        // center panel
        JPanel txtFieldPanel = new JPanel(new GridLayout(5, 1));
        txtFieldPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

        txtName = new JTextField(20);
        txtContactNumber = new JTextField(20);
        txtCompany = new JTextField(20);
        txtSalary = new JTextField(15);
        txtBirthday = new JTextField(15);

        JTextField[] textFields = { txtName, txtContactNumber, txtCompany, txtSalary, txtBirthday };
        for (JTextField txtFields : textFields) {
            txtFields.setFont(new Font("SansSerif", Font.PLAIN, 12));
            JPanel txtfieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            txtfieldPanel.add(txtFields);
            txtFieldPanel.add(txtfieldPanel);
        }
        add("Center", txtFieldPanel);

        // buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.setBorder(new EmptyBorder(20, 0, 20, 10));

        JPanel firstRow = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Add Contact Button
        btnAddContact = new JButton("ADD Contact");
        firstRow.add(btnAddContact);
        // Cancel Button
        btnCancel = new JButton("Cancel");
        firstRow.add(btnCancel);

        buttonPanel.add(firstRow);

        // Back to Home Page Btn
        JPanel secondRow = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        btnBack = new JButton("Back to Home Page");
        btnBack.setPreferredSize(new Dimension(183, 25));
        secondRow.add(btnBack);
        buttonPanel.add(secondRow);

        add("South", buttonPanel);

        btnAddContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String id = contactId;
                String name = txtName.getText();
                String contactNumber = txtContactNumber.getText();
                String company = txtCompany.getText();
                double salary = Double.parseDouble(txtSalary.getText());
                String birthday = txtBirthday.getText();

                if (!ContactController.phoneNumberValidating(contactNumber)) {
                    JOptionPane.showMessageDialog(null, "Invalid Phone Number !!");
                } else if (!ContactController.salaryValidating(salary)) {
                    JOptionPane.showMessageDialog(null, "Invalid Salary !!");
                } else if (!ContactController.validateBirthday(birthday)) {
                    JOptionPane.showMessageDialog(null, "Invalid Birthday !!");
                } else {
                    Contact contact = new Contact(id, name, contactNumber, company, salary, birthday);
                    boolean added = ContactController.addContact(contact);
                    if (added) {
                        JOptionPane.showMessageDialog(null, "Contact added successfully!");

                        txtName.setText("");
                        txtContactNumber.setText("");
                        txtCompany.setText("");
                        txtSalary.setText("");
                        txtBirthday.setText("");

                        String contactId = ContactController.generateNextContactId();
                        lblContactId.setText("Contact ID - " + contactId);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add contact!");
                    }
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtName.setText("");
                txtContactNumber.setText("");
                txtCompany.setText("");
                txtSalary.setText("");
                txtBirthday.setText("");
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new HomePage().setVisible(true);
                AddContactForm.this.dispose();
            }
        });

    }
}
