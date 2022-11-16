package tree;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
public class SimpleJTree extends JFrame
{
    public void init(){
        Container contentPane = getContentPane();
        //四个步骤
        //创建对象代表节点
        DefaultMutableTreeNode root =new DefaultMutableTreeNode("中国");
        DefaultMutableTreeNode guangDong =new DefaultMutableTreeNode("广东");
        DefaultMutableTreeNode guangXi =new DefaultMutableTreeNode("广西");
        DefaultMutableTreeNode foShan =new DefaultMutableTreeNode("佛山");
        DefaultMutableTreeNode shanTou =new DefaultMutableTreeNode("汕头");
        DefaultMutableTreeNode guiLin =new DefaultMutableTreeNode("桂林");
        DefaultMutableTreeNode nanNing =new DefaultMutableTreeNode("南宁");
        //组装节点之间的关系
        root.add(guangDong);
        root.add(guangXi);
        guangDong.add(foShan);
        guangDong.add(shanTou);
        guangXi.add(guiLin);
        guangXi.add(nanNing);
        //创建JTree对象
        JTree tree = new JTree(root);
        //把JTree放入到窗口中进行展示
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
