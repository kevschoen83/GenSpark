package ConfirmationDialog;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckExitExample extends JFrame {

    public CheckExitExample() {
        setSize(300, 300);
        setTitle("Window Listener");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new CheckOnExit());
    }

    private class CheckOnExit extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            ConfirmWindow checker = new ConfirmWindow();
            checker.setVisible(true);
        }
    }
}
