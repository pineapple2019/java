package ee.ds;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class JFrameTest extends JFrame {
    JTextArea jt = new JTextArea("服务器已经开启...");
    public JFrameTest(){
        setTitle("测试修改字体");
//        setFont(new Font("微软雅黑", Font.PLAIN, 30));
        add(jt);
//        jt.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        setSize(450,500);
        jt.setSize(300,500);
        setVisible(true);
    }
    //设置全局字体
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
    public static void main(String[] args) {
        InitGlobalFont(new Font("alias", Font.PLAIN, 50));  //统一设置字体
        new JFrameTest();
    }
}

