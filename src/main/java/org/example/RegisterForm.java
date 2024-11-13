package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterForm extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private Account account;

    public RegisterForm() {
        setTitle("Register Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        registerButton = new JButton("Register");
        panel.add(registerButton);

        add(panel);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Business business = new Business();
                try {
                    collectUserDetails();
                    business.saveUser(getAccount());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    public void collectUserDetails() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        account = new Account(email, password);
    }

    public Account getAccount() {
        return account;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }


}