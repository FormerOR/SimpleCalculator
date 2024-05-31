package Listener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//负责处理按钮的加法点击事件
public class AddListener implements ActionListener{
    //文本框1
    private JTextField textField1;
    //文本框2
    private JTextField textField2;
    //文本框3
    private JTextField textField3;

    //构造函数
    public AddListener(JTextField textField1, JTextField textField2, JTextField textField3) {
        this.textField1 = textField1;
        this.textField2 = textField2;
        this.textField3 = textField3;
    }

    //处理按钮点击事件
    public void actionPerformed(ActionEvent e) {
        // 检测输入是否为数字，如果否则弹窗提示
        try {
            //获取文本框1的内容
            String text1 = textField1.getText();
            //获取文本框2的内容
            String text2 = textField2.getText();
            //将文本框1的内容转换为整数
            int num1 = Integer.parseInt(text1);
            //将文本框2的内容转换为整数
            int num2 = Integer.parseInt(text2);
            //计算结果
            int result = num1 + num2;
            //将结果显示在文本框3中
            textField3.setText(result + "");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "请输入数字", "错误", JOptionPane.ERROR_MESSAGE);
        }


    }
}
