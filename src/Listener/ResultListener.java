package Listener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ResultListener implements ActionListener{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public ResultListener(JTextField textField1, JTextField textField2, JTextField textField3) {
        this.textField1 = textField1;
        this.textField2 = textField2;
        this.textField3 = textField3;
    }

    public void actionPerformed(ActionEvent e) {
        // 检测输入是否为数字，如果否则弹窗提示
        try {
            String text1 = textField1.getText();
            String text2 = textField2.getText();
            int num1 = Integer.parseInt(text1);
            int num2 = Integer.parseInt(text2);
            int result = num1 + num2;
            textField3.setText(result + "");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "请输入数字", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
