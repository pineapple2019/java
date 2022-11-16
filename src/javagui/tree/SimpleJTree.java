package tree;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
public class SimpleJTree extends JFrame
{
    public void init(){
        Container contentPane = getContentPane();
        //�ĸ�����
        //�����������ڵ�
        DefaultMutableTreeNode root =new DefaultMutableTreeNode("�й�");
        DefaultMutableTreeNode guangDong =new DefaultMutableTreeNode("�㶫");
        DefaultMutableTreeNode guangXi =new DefaultMutableTreeNode("����");
        DefaultMutableTreeNode foShan =new DefaultMutableTreeNode("��ɽ");
        DefaultMutableTreeNode shanTou =new DefaultMutableTreeNode("��ͷ");
        DefaultMutableTreeNode guiLin =new DefaultMutableTreeNode("����");
        DefaultMutableTreeNode nanNing =new DefaultMutableTreeNode("����");
        //��װ�ڵ�֮��Ĺ�ϵ
        root.add(guangDong);
        root.add(guangXi);
        guangDong.add(foShan);
        guangDong.add(shanTou);
        guangXi.add(guiLin);
        guangXi.add(nanNing);
        //����JTree����
        JTree tree = new JTree(root);
        //��JTree���뵽�����н���չʾ
        contentPane.add(tree);
        setBounds(300,300,300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleJTree().init();
    }
}
