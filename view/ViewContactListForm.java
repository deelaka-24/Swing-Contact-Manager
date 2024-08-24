package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewContactListForm extends JFrame {
    private JLabel lblTitle;

    private JButton btnListByName;
    private JButton btnListBySalary;
    private JButton btnListBirthDay;
    private JButton btnCancel;

    ViewContactListForm() {
        setSize(600, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel titlePanel = new JPanel(new GridLayout(1, 1));

        lblTitle = new JLabel("CONTACT LIST");
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
        JPanel txtTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtTitlePanel.setBackground(Color.decode("#99cdfd"));
        txtTitlePanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        txtTitlePanel.add(lblTitle);
        titlePanel.add(txtTitlePanel);
        add("North", titlePanel);

        // Button panel
        JPanel btnPanel = new JPanel(new GridLayout(3, 1));
        btnPanel.setBorder(new EmptyBorder(30, 0, 0, 0));

        btnListByName = new JButton("List By Name");
        btnListBySalary = new JButton("List By Salary");
        btnListBirthDay = new JButton("List By Birthday");

        JButton[] buttons = { btnListByName, btnListBySalary, btnListBirthDay };

        for (JButton button : buttons) {
            button.setFont(new Font("SansSerif", Font.BOLD, 20));
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            button.setPreferredSize(new Dimension(300, 40));
            panel.add(button);
            btnPanel.add(panel);
        }

        add("Center", btnPanel);

        // Cancel button
        JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
        buttonPanel.setBorder(new EmptyBorder(20, 0, 20, 10));

        JPanel secondRow = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("SansSerif", Font.BOLD, 20));
        btnCancel.setPreferredSize(new Dimension(155, 40));
        secondRow.add(btnCancel);
        buttonPanel.add(secondRow);

        add("South", buttonPanel);

        btnListByName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new ListByName().setVisible(true);
                ViewContactListForm.this.dispose();
            }
        });

        btnListBySalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new ListBySalary().setVisible(true);
                ViewContactListForm.this.dispose();
            }
        });

        btnListBirthDay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new ListByBirthDay().setVisible(true);
                ViewContactListForm.this.dispose();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new HomePage().setVisible(true);
                ViewContactListForm.this.dispose();
            }
        });
    }
}
