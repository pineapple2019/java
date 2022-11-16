package tree;
import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;
import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleJTree2
{
    JFrame J=new JFrame();
    //定义需要被拖动的TreePath
    TreePath movePath;

    //定义按钮，完成操作
    JButton addSiblingBtn = new JButton("添加兄弟结点");
    JButton addChildBtn = new JButton("添加子结点");
    JButton deleteBtn = new JButton("删除结点");
    JButton editBtn = new JButton("编辑当前结点");
    public void init(){

        //四个步骤
        //创建对象代表节点
        DefaultMutableTreeNode root =new DefaultMutableTreeNode("owl：Thing");
        DefaultMutableTreeNode guangDong =new DefaultMutableTreeNode("传感资源");
        DefaultMutableTreeNode guangXi =new DefaultMutableTreeNode("存储资源");

        DefaultMutableTreeNode foShan =new DefaultMutableTreeNode("武器资源");
        DefaultMutableTreeNode shanTou =new DefaultMutableTreeNode("网络资源");
        DefaultMutableTreeNode guiLin =new DefaultMutableTreeNode("计算资源");
        DefaultMutableTreeNode guiLin1 =new DefaultMutableTreeNode("传感器");
        DefaultMutableTreeNode guiLin2 =new DefaultMutableTreeNode("雷达");
        DefaultMutableTreeNode guiLin3 =new DefaultMutableTreeNode("主存");
        DefaultMutableTreeNode guiLin4 =new DefaultMutableTreeNode("辅存");
        DefaultMutableTreeNode guiLin5 =new DefaultMutableTreeNode("导弹");
        DefaultMutableTreeNode guiLin6 =new DefaultMutableTreeNode("火炮");
        DefaultMutableTreeNode guiLin7 =new DefaultMutableTreeNode("信息传输链");
        DefaultMutableTreeNode guiLin8 =new DefaultMutableTreeNode("甚高频通讯");
        DefaultMutableTreeNode guiLin10 =new DefaultMutableTreeNode("高频通讯");
        DefaultMutableTreeNode guiLin11 =new DefaultMutableTreeNode("处理机");
        DefaultMutableTreeNode guiLin12 =new DefaultMutableTreeNode("计算机");

//        DefaultMutableTreeNode nanNing =new DefaultMutableTreeNode("南宁");
        //组装节点之间的关系
        root.add(guangDong);
        root.add(guangXi);
        root.add(foShan);
        root.add(shanTou);

        root.add(guiLin);
        root.add(guiLin1);
        root.add(guiLin2);
        root.add(guiLin3);
        root.add(guiLin4);
        guangDong.add(guiLin1);
        guangDong.add(guiLin2);
        guangXi.add(guiLin3);
        guangXi.add(guiLin4);

//武器资源
        foShan.add(guiLin5);
        foShan.add(guiLin6);
        //网络资源
        shanTou.add(guiLin7);
        shanTou.add(guiLin8);
        shanTou.add(guiLin10);
        //计算资源
        guiLin.add(guiLin11);
        guiLin.add(guiLin12);
//        guiLin.add(guiLin10);
        //创建JTree对象
        JTree tree = new JTree(root);
        //把JTree放入到窗口中进行展示

        //完成数节点编辑代码
        tree.setEditable(true);
//        TreeModel model = tree.getModel();
        DefaultTreeModel model = (DefaultTreeModel)tree.getModel(); //强制转换，方便我们使用API

        //处理添加
        addSiblingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //添加兄弟节点逻辑

                //1，获取当前选中的节点
            DefaultMutableTreeNode selectedNode=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

            if (selectedNode==null){
                return;
            }
                //2，获取当前节点的父节点

                //3，创建新节点
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新节点");
            selectedNode.add(newNode);
                //4,把新节点通过父节点，进行添加

                //5，显示新节点
                TreeNode[] pathToRoot = model.getPathToRoot(newNode);
                TreePath treePath = new TreePath(pathToRoot);
                tree.scrollPathToVisible(treePath);
                //6，重绘tree


            }
       });


        J.add(tree);
        J.setBounds(300,300,300,300);
        J.setDefaultCloseOperation(J.EXIT_ON_CLOSE);
//        pack();
        J.setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleJTree2().init();
    }
}
