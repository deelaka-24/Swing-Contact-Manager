package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.ContactController;

import java.awt.*;
import java.awt.event.*;

class DeleteContactForm extends JFrame {
    private JLabel lblTitle;
    private JTextField searchTxtField;
    private JButton btnSearch;

    private JLabel lblContactId;
    private JLabel lblName;
    private JLabel lblContactNumber;
    private JLabel lblCompany;
    private JLabel lblSalary;
    private JLabel lblBirthday;

    private JLabel displayLblContactId;
    private JLabel displayLblName;
    private JLabel displayLblContactNumber;
    private JLabel displayLblCompany;
    private JLabel displayLblSalary;
    private JLabel displayLblBirthday;

    private JButton btnDelete;
    private JButton btnCancel;
    private JButton btnBack;

    DeleteContactForm() {
        setSize(400, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel titlePanel = new JPanel(new GridLayout(2, 1));

        lblTitle = new JLabel("DELETE CONTACT");
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
        JPanel txtTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtTitlePanel.setBackground(Color.decode("#99cdfd"));
        txtTitlePanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        txtTitlePanel.add(lblTitle);
        titlePanel.add(txtTitlePanel);

        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        searchTxtField = new JTextField(20);
        searchTxtField.setFont(new Font("SansSerif", Font.PLAIN, 12));
        searchTxtField.setMargin(new Insets(3, 0, 3, 0));
        searchPanel.add(searchTxtField);

        btnSearch = new JButton("Search");
        searchPanel.add(btnSearch);

        titlePanel.add(searchPanel);

        add("North", titlePanel);

        // Unified Panel with GridLayout(6, 2)
        JPanel unifiedPanel = new JPanel(new GridLayout(6, 2));
        unifiedPanel.setBorder(new EmptyBorder(10, 60, 10, 20));

        lblContactId = new JLabel("Contact ID:");
        lblName = new JLabel("Name:");
        lblContactNumber = new JLabel("Contact Number:");
        lblCompany = new JLabel("Company:");
        lblSalary = new JLabel("Salary:");
        lblBirthday = new JLabel("Birthday:");

        displayLblContactId = new JLabel();
        displayLblName = new JLabel();
        displayLblContactNumber = new JLabel();
        displayLblCompany = new JLabel();
        displayLblSalary = new JLabel();
        displayLblBirthday = new JLabel();

        JLabel[] labels = { lblContactId, lblName, lblContactNumber, lblCompany, lblSalary, lblBirthday };
        JLabel[] displayLabels = { displayLblContactId, displayLblName, displayLblContactNumber, displayLblCompany,
                displayLblSalary, displayLblBirthday };

        for (int i = 0; i < labels.length; i++) {
            labels[i].setFont(new Font("SansSerif", Font.BOLD, 18));
            displayLabels[i].setFont(new Font("SansSerif", Font.PLAIN, 18));
            unifiedPanel.add(labels[i]);
            unifiedPanel.add(displayLabels[i]);
        }

        add("Center", unifiedPanel);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.setBorder(new EmptyBorder(20, 0, 20, 10));

        JPanel firstRow = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Delete Button
        btnDelete = new JButton("DELETE");
        firstRow.add(btnDelete);
        // Cancel Button
        btnCancel = new JButton("Cancel");
        firstRow.add(btnCancel);

        buttonPanel.add(firstRow);

        // Back to Home Page Button
        JPanel secondRow = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        btnBack = new JButton("Back to Home Page");
        btnBack.setPreferredSize(new Dimension(155, 25));
        secondRow.add(btnBack);
        buttonPanel.add(secondRow);

        add("South", buttonPanel);

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String searchKey = searchTxtField.getText();
                int index = ContactController.search(searchKey);
                if (index != -1 && !searchKey.isEmpty()) {
                    displayLblContactId.setText(ContactController.getContactID(index));
                    displayLblName.setText(ContactController.getName(index));
                    displayLblContactNumber.setText(ContactController.getPhoneNumber(index));
                    displayLblCompany.setText(ContactController.getCompanyName(index));
                    displayLblSalary.setText(String.valueOf(ContactController.getSalary(index)));
                    displayLblBirthday.setText(ContactController.getBirthday(index));
                } else {
                    JOptionPane.showMessageDialog(null, "No Contact Found !");
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int index = ContactController.search(searchTxtField.getText());
                ContactController.remove(index);
                JOptionPane.showMessageDialog(null, "Successfully Deleted !");
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new HomePage().setVisible(true);
                DeleteContactForm.this.dispose();
            }
        });
    }

}
