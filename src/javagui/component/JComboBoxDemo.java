package component;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class JComboBoxDemo
{
    public static void main(String[] args)
    {
        JFrame frame=new JFrame("Java�����б����ʾ��");
        JPanel jp=new JPanel();    //�������
        JLabel label1=new JLabel("֤�����ͣ�");    //������ǩ
        JComboBox cmb=new JComboBox();    //����JComboBox
        cmb.addItem("--��ѡ��--");    //�������б������һ��
        cmb.addItem("���֤");
        cmb.addItem("��ʻ֤");
        cmb.addItem("����֤");
        jp.add(label1);
        jp.add(cmb);
        frame.add(jp);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


