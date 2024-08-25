package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.ContactController;

import java.awt.*;
import java.awt.event.*;

class SerachContactForm extends JFrame {
    private JLabel lblTitle;
    private JTextField searchTxtField;
    private JButton btnSearch;

    private JLabel lblContactId;
    private JLabel lblName;
    private JLabel lblContactNumber;
    private JLabel lblCompany;
    private JLabel lblSalary;
    private JLabel lblBirthday;

    private JTextField displayLblContactId;
    private JTextField displayLblName;
    private JTextField displayLblContactNumber;
    private JTextField displayLblCompany;
    private JTextField displayLblSalary;
    private JTextField displayLblBirthday;

    private JButton btnBack;

    SerachContactForm() {
        setSize(400, 450); // Adjusted size to fit both panels
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title Panel
        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        lblTitle = new JLabel("SERACH CONTACT");
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

        // West Panel
        JPanel txtLabelPanel = new JPanel(new GridLayout(6, 1));
        txtLabelPanel.setBorder(new EmptyBorder(0, 50, 0, 0));
        lblContactId = new JLabel("Contact ID");
        lblName = new JLabel("Name");
        lblContactNumber = new JLabel("Contact Number");
        lblCompany = new JLabel("Company");
        lblSalary = new JLabel("Salary");
        lblBirthday = new JLabel("Birthday");
        JLabel[] labels = { lblContactId, lblName, lblContactNumber, lblCompany, lblSalary, lblBirthday };

        for (JLabel label : labels) {
            label.setFont(new Font("SansSerif", Font.BOLD, 15));
            JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            labelPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
            labelPanel.add(label);
            txtLabelPanel.add(labelPanel);
        }
        add("West", txtLabelPanel);

        // East Panel
        JPanel txtFieldPanel = new JPanel(new GridLayout(6, 1));
        txtFieldPanel.setBorder(new EmptyBorder(0, 10, 0, 10));
        displayLblContactId = new JTextField(15);
        displayLblName = new JTextField(15);
        displayLblContactNumber = new JTextField(15);
        displayLblCompany = new JTextField(15);
        displayLblSalary = new JTextField(10);
        displayLblBirthday = new JTextField(10);
        JTextField[] textFields = { displayLblContactId, displayLblName, displayLblContactNumber, displayLblCompany,
                displayLblSalary, displayLblBirthday };

        for (JTextField textField : textFields) {
            textField.setFont(new Font("SansSerif", Font.PLAIN, 12));
            JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            textFieldPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
            textFieldPanel.add(textField);
            txtFieldPanel.add(textFieldPanel);
        }
        add("East", txtFieldPanel);

        // South Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
        buttonPanel.setBorder(new EmptyBorder(20, 0, 20, 10));

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

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new HomePage().setVisible(true);
                SerachContactForm.this.dispose();
            }
        });
    }
}
