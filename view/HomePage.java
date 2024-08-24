package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

class HomePage extends JFrame {
    private JLabel lblHomePage;
    private JButton btnAddContact;
    private JButton btnUpdateContact;
    private JButton btnSearchContact;
    private JButton btnDeleteContact;
    private JButton btnViewContact;
    private JButton btnExit;

    public HomePage() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        lblHomePage = new JLabel("Home Page");
        lblHomePage.setHorizontalAlignment(JLabel.CENTER);
        lblHomePage.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(lblHomePage, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel(new GridLayout(5, 1, 0, 0));

        btnAddContact = new JButton("Add New Contact");
        btnUpdateContact = new JButton("Update Contact");
        btnSearchContact = new JButton("Search Contact");
        btnDeleteContact = new JButton("Delete Contact");
        btnViewContact = new JButton("View Contact");

        JButton[] buttons = { btnAddContact, btnUpdateContact, btnSearchContact, btnDeleteContact, btnViewContact };

        for (JButton button : buttons) {
            button.setFont(new Font("", Font.PLAIN, 15));
            button.setPreferredSize(new Dimension(300, 40));
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(button);
            btnPanel.add(buttonPanel);
        }

        add(btnPanel, BorderLayout.CENTER);

        JPanel exitBtnPanel = new JPanel(new BorderLayout());
        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("SansSerif", Font.PLAIN, 15));
        btnExit.setPreferredSize(new Dimension(100, 30));
        exitBtnPanel.add(btnExit, BorderLayout.EAST);
        exitBtnPanel.setBorder(new EmptyBorder(10, 0, 10, 10));
        add(exitBtnPanel, BorderLayout.SOUTH);

        btnAddContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new AddContactForm().setVisible(true);
                HomePage.this.dispose();
            }
        });

        btnUpdateContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new UpdateContactForm().setVisible(true);
                HomePage.this.dispose();
            }
        });

        btnSearchContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new SerachContactForm().setVisible(true);
                HomePage.this.dispose();
            }
        });

        btnDeleteContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new DeleteContactForm().setVisible(true);
                HomePage.this.dispose();
            }
        });

        btnViewContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new ViewContactListForm().setVisible(true);
                HomePage.this.dispose();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new HomePage().setVisible(true);
    }
}
