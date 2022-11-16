package trans;

import javax.swing.*;
import java.awt.*;

/**
 * 先定位好一个组件的位置，然后其他组件都相对于这个组件定位
 */

public class SpringLayoutTest extends JFrame {



    //设置jpanel的布局管理器为springlayout,虽然其默认布局也是springlayout
    SpringLayout springLayout=new SpringLayout();
    JPanel jPanel= new JPanel(springLayout);

    JLabel titleLable  = new JLabel("文章标题");
    JTextField titleTxt = new JTextField();

    JLabel authorLabel  = new JLabel("作者");
    JTextField authorTxt = new JTextField();

    JLabel contLabel = new JLabel("请输入内容");
    JTextArea contArea  = new JTextArea(4,10);

    public SpringLayoutTest(){

        super("标题");
        Container contentPane = getContentPane();

        //加入到jpanel中
        jPanel.add(titleLable);
        //设置文本框的大小
        titleTxt.setPreferredSize(new Dimension(200,30));
        jPanel.add(titleTxt);
        jPanel.add(authorLabel);
        jPanel.add(authorTxt);
        authorTxt.setPreferredSize(new Dimension(200,30));
//        jPanel.add(contLabel);
//        jPanel.add(contArea);
        /**
         * 先找布局约束
         * SpringLayout.Constraints：每个组件对应一个，弹簧布局的容器里面组件的布局约束
         *spring可以理解为一个能够进行四则运算的整数
         */



        SpringLayout.Constraints titleLabelC=springLayout.getConstraints(titleLable);
        titleLabelC.setX(Spring.constant(100));//参数是spring类型的，所以需要包装成spring类型的常数
        titleLabelC.setY(Spring.constant(80));


        /**
         * 设置约束的第一种写法，比较复杂
         */

        //设置标题文本框，titleTxt东边距离titleLabel的西边20px，北边相同
        SpringLayout.Constraints titleTxtC=springLayout.getConstraints(titleTxt);
        //edgeName:东南西北 s：值
        Spring titleLabelEastSpring =titleLabelC.getConstraint(SpringLayout.EAST);
        titleTxtC.setConstraint(SpringLayout.WEST,Spring.sum(titleLabelEastSpring,Spring.constant(20)));
        //设置北边
        titleTxtC.setConstraint(SpringLayout.NORTH,titleLabelC.getConstraint(SpringLayout.NORTH));

        /**
         * 设置约束的第二种写法，相对简单
         *e1:要设置组件的哪个边界（edgeName）
         *c1：要设置的组件
         *pad：距离值
         * e2：参照的组件的边界名
         * 参照物（组件）
         * 设置作者label，authorLabel，东边和titleLabel对齐
         */
        springLayout.putConstraint(SpringLayout.EAST,authorLabel,0,SpringLayout.EAST,titleLable);
        //北边距离titleLabel，南边20px
        springLayout.putConstraint(SpringLayout.NORTH,authorLabel,20,SpringLayout.SOUTH,titleLable);


        /**
         * 设置authorTxt：authorTxt西边距离authorTxt的东边20px，北边和authorLabel相同
         */
        springLayout.putConstraint(SpringLayout.WEST,authorTxt,20,SpringLayout.EAST,authorLabel);
        springLayout.putConstraint(SpringLayout.NORTH,authorTxt,0,SpringLayout.NORTH,authorLabel);
        /**
         * contLable
         */



        //然后再加入到内容面板里面去
        contentPane.add(jPanel);


        //设置大小
        setSize(600,400);
        //居中
        setLocationRelativeTo(null);
        //关闭退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //大小不可改变
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SpringLayoutTest();
    }
}
