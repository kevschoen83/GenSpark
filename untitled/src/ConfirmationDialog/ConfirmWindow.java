package ConfirmationDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmWindow extends JFrame implements ActionListener {

    public ConfirmWindow() {
        setSize(250, 100);
        setLayout(new BorderLayout());

        JLabel confirmLabel = new JLabel(
                "Are you sure you want to exit?", SwingConstants.CENTER);
        add(confirmLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton exitButton = new JButton("Yes");
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);

        JButton cancelButton = new JButton("No");
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals("Yes")) {
            System.exit(0);
        } else if (action.equals("No")) {
            dispose();
        }
    }

}
