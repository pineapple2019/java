//package calculator;
//
//import javax.swing.*;
//import javax.swing.plaf.FontUIResource;
//import java.awt.*;
//import java.util.Enumeration;
//
//public class Calculator extends JFrame {
//
//    final JTextField textField;
//    private String result;
//    private double numA;
//    private double numB;
//    private String operator;
//    private double memory;
//    //
//    public static void main(String[] args) {
//        InitGlobalFont(new Font("alias", Font.PLAIN, 15));  //统一设置字体
//        //new一个这个对象，就相当于造了一个计算器一样，想想猫狗的例子
//        Calculator calculator = new Calculator();
//        calculator.setVisible(true);
//
//    }
//    /**
//     * 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体
//     */
//    private static void InitGlobalFont(Font font) {
//        FontUIResource fontRes = new FontUIResource(font);
//        for (Enumeration<Object> keys = UIManager.getDefaults().keys();
//             keys.hasMoreElements(); ) {
//            Object key = keys.nextElement();
//            Object value = UIManager.get(key);
//            if (value instanceof FontUIResource) {
//                UIManager.put(key, fontRes);
//            }
//        }
//    }
//
//    public Calculator(){
////        super();
//        setTitle("科学计算器");
//        setBounds(600,600,400,400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //初始化  网格组布局管理器
//        GridBagLayout gbl = new GridBagLayout();
//        //设计计算器头部
//        JPanel viewPanel = new JPanel();
//        viewPanel.setLayout(gbl);
//        //头部大小
//        viewPanel.setPreferredSize(new Dimension(200,100));
//        //将头部放到相应的位置
//        getContentPane().add(viewPanel,BorderLayout.NORTH);
//        textField = new JTextField();
//        textField.setHorizontalAlignment(SwingConstants.RIGHT);//设置文本框字体方向
//        textField.setFont(new Font("Microsoft Uighur",Font.ITALIC,30));//设置文本框字体大小
////        textField.
//        gbl.setConstraints(textField,new GBS);
//    }
//    class GBS{
//        GridBagConstraints gbs = new GridBagConstraints();
//    }
//
//
//}
