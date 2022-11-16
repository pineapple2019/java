package ee;


import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class Calculator extends JFrame {
    public static void main(String[] args) {
        InitGlobalFont(new Font("alias", Font.PLAIN, 15));  //统一设置字体

    }

    /**
     * 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体
     */
    private static void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys();
             keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }

    public Calculator(){
        setTitle("科学计算器");
        setBounds(500,500,300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }
}
