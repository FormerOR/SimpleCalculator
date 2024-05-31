package Listener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public ClearListener(JTextField textField1, JTextField textField2, JTextField textField3) {
        this.textField1 = textField1;
        this.textField2 = textField2;
        this.textField3 = textField3;
    }

    public void actionPerformed(ActionEvent e) {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
    }
}
