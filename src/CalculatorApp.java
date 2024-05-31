import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Listener.*;

/*

图形用户界面的简易计算器
（1）设计并实现一个简易计算器GUI应用；
（2）支持加、减、乘、除基本运算；
（3）支持清除输入和结果显示功能；
（4）使用Swing组件创建用户界面，例如使用JFrame, JTextField, JButton等；
（5）使用布局管理器合理排列组件；
（6）为按钮添加事件监听器，实现计算逻辑和界面交互。

项目结构大致如下：
CalculatorApp：主类，继承自JFrame，负责构建UI框架，初始化组件，设置布局。
CalculatorEngine：处理数学运算的逻辑。
运算监听器类：一系列实现ActionListener的类，负责处理按钮点击事件，包括数字输入、运算和结果显示的更新。
使用Swing组件（如JFrame, JTextField, JButton）构建UI。
应用合适的布局管理器（如BorderLayout, GridLayout）来组织组件。
通过事件监听机制（ActionListener）实现用户交互逻辑。

界面设计：
3个文本框
一个是被加数/被减数/被乘数/被除数
一个是加数/减数/乘数/除数
一个是和/差/积/商
4个运算符号按钮
1个计算结果按钮
1个清除按钮

 */

// 设置面板布局为三个文本框一行，四个算法按钮一行，一个计算按钮一行，一个清除按钮一行
public class CalculatorApp extends JFrame{
    // 构造函数、初始化组件、设置布局等
    public CalculatorApp(){
        // 设置窗口标题
        setTitle("简易计算器");
        // 设置窗口大小
        setSize(800, 320);
        // 设置窗口关闭按钮的默认操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口位置
        setLocationRelativeTo(null);
        // 设置窗口大小不可变
        setResizable(true);

        // 创建主容器面板，并使用BorderLayout布局
        JPanel mainPanel = new JPanel(new BorderLayout());
        // 创建中心区域面板用于放置文本框，使用GridLayout布局
        JPanel centerPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        // 设置中心区域面板高度为窗口高度的1/3
        centerPanel.setPreferredSize(new Dimension(0, getHeight() / 3));
        // 创建南区域面板用于放置按钮，使用BoxLayout布局
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));


        // 创建三个label显示三个文本框的提示信息：操作数1、操作数2、计算结果
        JLabel label1 = new JLabel("操作数1");
        JLabel label2 = new JLabel("操作数2");
        JLabel label3 = new JLabel("计算结果");
        // 设置字体大小
        setFontSizes(new JComponent[]{label1, label2, label3}, 30);
        // 设置字体颜色
        setFontColors(new JComponent[]{label1, label2, label3}, Color.BLUE);
        // 设置控件大小
        setSizes(new JComponent[]{label1, label2, label3}, 100, 50);
        // 设置文本居中
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        // 将label加入到centerPanel
        centerPanel.add(label1);
        centerPanel.add(label2);
        centerPanel.add(label3);

        // 创建文本框并加入到centerPanel
        // 设置文本框内容居中显示字体大小设置为10
        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);
        JTextField textField3 = new JTextField(10);
        textField1.setHorizontalAlignment(JTextField.CENTER);
        textField2.setHorizontalAlignment(JTextField.CENTER);
        textField3.setHorizontalAlignment(JTextField.CENTER);
        // 设置字体大小
        setFontSizes(new JComponent[]{textField1, textField2, textField3}, 80);

        textField3.setEditable(false);
        centerPanel.add(textField1);
        centerPanel.add(textField2);
        centerPanel.add(textField3);

        // 创建算法按钮和计算、清除按钮的容器
        JPanel algoButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JPanel calcClearButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

        // 创建按钮并加入到相应的面板
        JButton add_button = new JButton("+");
        JButton minus_button = new JButton("-");
        JButton multi_button = new JButton("*");
        JButton div_button = new JButton("/");
        JButton cal_button = new JButton("=");
        JButton clr_button = new JButton("C");

        // 设置按钮大小
        setSizes(new JComponent[]{add_button, minus_button, multi_button, div_button, cal_button, clr_button}, 100, 50);
        // 设置按钮字体大小
        setFontSizes(new JComponent[]{add_button, minus_button, multi_button, div_button, cal_button, clr_button}, 30);

        algoButtonsPanel.add(add_button);
        algoButtonsPanel.add(minus_button);
        algoButtonsPanel.add(multi_button);
        algoButtonsPanel.add(div_button);

        calcClearButtonsPanel.add(cal_button);
        calcClearButtonsPanel.add(clr_button);

        // 添加监听器到按钮
        add_button.addActionListener(new AddListener(textField1, textField2, textField3));
        minus_button.addActionListener(new SubListener(textField1, textField2, textField3));
        multi_button.addActionListener(new MulListener(textField1, textField2, textField3));
        div_button.addActionListener(new DivListener(textField1, textField2, textField3));
        cal_button.addActionListener(new ResultListener(textField1, textField2, textField3));
        clr_button.addActionListener(new ClearListener(textField1, textField2, textField3));

        // 将按钮面板加入到southPanel
        southPanel.add(algoButtonsPanel);
        southPanel.add(Box.createVerticalStrut(10)); // 间距
        southPanel.add(calcClearButtonsPanel);

        // 将各部分加入到主容器
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        // 添加主面板到窗口
        add(mainPanel);
    }

    // 设置多个控件的大小
    public void setSizes(JComponent[] components, int width, int height){
        for(JComponent component : components){
            component.setPreferredSize(new Dimension(width, height));
        }
    }

    // 设置控件文本字体大小
    public void setFontSizes(JComponent[] components, int size){
        for(JComponent component : components){
            component.setFont(new Font(null, Font.PLAIN, size));
        }
    }

    // 设置控件字体颜色
    public void setFontColors(JComponent[] components, Color color){
        for(JComponent component : components){
            component.setForeground(color);
        }
    }

}
