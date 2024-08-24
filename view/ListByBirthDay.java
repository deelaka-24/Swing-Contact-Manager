package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        String[] columnNames = { "Contact ID", "Name", "Contact Number", "Company", "Salary", "Birthday" };
        Object[][] data = {
                { "1", "John Doe", "123-456-7890", "Company A", "$50,000", "01/01/1980" },
                { "2", "Jane Smith", "098-765-4321", "Company B", "$60,000", "02/02/1990" },
        };

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
