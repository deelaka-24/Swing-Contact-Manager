package view;

import model.Contact;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.ContactController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ListByBirthDay extends JFrame {
    private JLabel lblTitle;
    private JTable tblListByBirthDay;
    private JButton btnBack;

    ListByBirthDay() {
        setSize(700, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title panel
        JPanel titlePanel = new JPanel(new GridLayout(1, 1));

        lblTitle = new JLabel("LIST CONTACTS BY BIRTHDAY");
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
        JPanel txtTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtTitlePanel.setBackground(Color.decode("#99cdfd"));
        txtTitlePanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        txtTitlePanel.add(lblTitle);
        titlePanel.add(txtTitlePanel);
        add("North", titlePanel);

        // Table and scroll pane
        Contact[] contactArray = ContactController.birthdaySort();

        String[] columnNames = { "Contact ID", "Name", "Contact Number", "Company", "Salary", "Birthday" };
        Object[][] data = new Object[contactArray.length][columnNames.length];

        for (int i = 0; i < contactArray.length; i++) {
            Contact contact = contactArray[i];
            data[i][0] = contact.getId();
            data[i][1] = contact.getName();
            data[i][2] = contact.getPhoneNumber();
            data[i][3] = contact.getCompanyName();
            data[i][4] = contact.getSalary();
            data[i][5] = contact.getBirthday();
        }

        tblListByBirthDay = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tblListByBirthDay);
        tblListByBirthDay.setFillsViewportHeight(true);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        add("Center", tablePanel);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
        buttonPanel.setBorder(new EmptyBorder(20, 0, 20, 10));

        JPanel secondRow = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        btnBack = new JButton("Back to Home Page");
        btnBack.setPreferredSize(new Dimension(155, 25));
        secondRow.add(btnBack);
        buttonPanel.add(secondRow);

        add("South", buttonPanel);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new ViewContactListForm().setVisible(true);
                ListByBirthDay.this.dispose();
            }
        });
    }
}
