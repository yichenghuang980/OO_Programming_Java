package lab;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

public class UserForm {
    public static void main(String[] args) {
        String userName = "";
        String email = "";
        String phone = "";

        JFrame frame = new JFrame();
        frame.setTitle("User Form");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = 0;
        constr.gridy = 0;

        JLabel userNameLabel = new JLabel("Name");
        panel.add(userNameLabel, constr);
        JTextField userNameTxt = new JTextField(20);
        constr.gridx = 1;
        panel.add(userNameTxt, constr);

        constr.gridx = 0;
        constr.gridy = 1;
        JLabel emailLabel = new JLabel("Email");
        panel.add(emailLabel, constr);
        JTextField emailTxt = new JTextField(20);
        constr.gridx = 1;
        panel.add(emailTxt, constr);

        constr.gridx = 0;
        constr.gridy = 2;
        JLabel phoneLabel = new JLabel("Phone");
        panel.add(phoneLabel, constr);
        JTextField phoneTxt = new JTextField(20);
        constr.gridx = 1;
        panel.add(phoneTxt, constr);

        JButton editButton = new JButton("Edit");
        constr.gridx = 0;
        constr.gridy = 4;
        panel.add(editButton, constr);

        JButton saveButton = new JButton("Save");
        constr.gridx = 1;
        constr.gridy = 4;
        panel.add(saveButton, constr);

        // hidden labels
        JLabel hiddenUserName = new JLabel(userName);
        constr.gridx = 1;
        constr.gridy = 0;
        hiddenUserName.setVisible(false);
        panel.add(hiddenUserName, constr);

        JLabel hiddenEmailLabel = new JLabel(email);
        constr.gridx = 1;
        constr.gridy = 1;
        hiddenEmailLabel.setVisible(false);
        panel.add(hiddenEmailLabel, constr);

        JLabel hiddenPhoneLabel = new JLabel("Name");
        hiddenPhoneLabel.setVisible(false);
        constr.gridx = 1;
        constr.gridy = 2;
        panel.add(hiddenPhoneLabel, constr);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hiddenUserName.setText(userNameTxt.getText());
                hiddenEmailLabel.setText(emailTxt.getText());
                hiddenPhoneLabel.setText(phoneTxt.getText());
                hiddenUserName.setVisible(true);
                userNameTxt.setVisible(false);
                hiddenEmailLabel.setVisible(true);
                emailTxt.setVisible(false);
                hiddenPhoneLabel.setVisible(true);
                phoneTxt.setVisible(false);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hiddenUserName.setVisible(false);
                userNameTxt.setVisible(true);
                hiddenEmailLabel.setVisible(false);
                emailTxt.setVisible(true);
                hiddenPhoneLabel.setVisible(false);
                phoneTxt.setVisible(true);
            }
        });

        frame.add(panel);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
