package tree;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class SimpleJTree3
{
    JFrame jf = new JFrame("简单树");
    JTree tree;
    //定义几个初始结点
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    //定义按钮，完成操作
    JButton addSiblingBtn = new JButton("添加兄弟结点");
    JButton addChildBtn = new JButton("添加子结点");
    JButton deleteBtn = new JButton("删除结点");
    JButton editBtn = new JButton("编辑当前结点");

    public void init(){

        //通过add()方法创建父子层级关系
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);


        //根据根节点，创建树JTree
        tree = new JTree(root);

//jTree是组件，TreeModel数据模型对象




        tree.putClientProperty( "JTree.lineStyle", "None");  //设置结点之间没有连接线
//      tree.putClientProperty("JTree.lineStyle" , "Horizontal");   //设置结点之间只有水平分割线
        tree.setShowsRootHandles(true);     //设置根结点有"展开、折叠"图标
        tree.setRootVisible(false);         //隐藏根结点


//      jf.add(new JScrollPane(tree));
        jf.add(tree);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setBounds(666,666,400,500);  //设置了整个jf多大
//      jf.pack();
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleJTree3().init();
    }
}
