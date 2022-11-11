package team.index;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * @Author: 从南到北
 * @Date: 2021/12/31/19:24
 *
 *定义组件
 *初始化组件
 *使用网络编程完成数据传输（tcp、udp）
 *发送按钮的监听点击事件
 *这是个只有界面，然后不可以进行功能的实现
 *
 */

public class Client extends JFrame {

    public static void main(String[] args) {
        new Client();
    }

    //设置左侧内容
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("本体建模");
    DefaultMutableTreeNode sense = new DefaultMutableTreeNode("传感资源");
    DefaultMutableTreeNode storage = new DefaultMutableTreeNode("存储资源");
    DefaultMutableTreeNode weapon = new DefaultMutableTreeNode("武器资源");
    DefaultMutableTreeNode network = new DefaultMutableTreeNode("网络资源");
    DefaultMutableTreeNode compute = new DefaultMutableTreeNode("计算资源");



    //定义按钮，完成操作
//  JButton addSiblingBtn = new JButton("添加结点");
    JButton addChildBtn = new JButton("添加资源");
    JButton deleteBtn = new JButton("删除资源");
    JButton editBtn = new JButton("修改资源名称");

    public Client(){

        //将枝节点添加到根节点
        root.add(sense);
        root.add(storage);
        root.add(weapon);
        root.add(network);
        root.add(compute);

        //使用其创建叶节点，并且将叶子节点添加到不同的枝节点上，随便添加一些例子
        DefaultMutableTreeNode baicai =new DefaultMutableTreeNode("传感器");
        sense.add(baicai);
        DefaultMutableTreeNode dasuan = new DefaultMutableTreeNode("雷达");
        sense.add(dasuan);
        DefaultMutableTreeNode tudou = new DefaultMutableTreeNode("主存");
        sense.add(tudou);
        DefaultMutableTreeNode pingguo = new DefaultMutableTreeNode("导弹");
        storage.add(pingguo);
        DefaultMutableTreeNode xiangjiao = new DefaultMutableTreeNode("火炮");
        storage.add(xiangjiao);
        DefaultMutableTreeNode xigua = new DefaultMutableTreeNode("处理器");
        storage.add(xigua);

        JTree tree = new JTree(root);
        tree.setEditable(true);     //设置JTree为可编辑
        JPanel panel = new JPanel();    //创建中间容器

        /**
         * 上面是树
         * 下面是按钮
         * 将滚动条和面板添加到窗口
         */

         JScrollPane jsp = new JScrollPane(tree);
         panel.add(addChildBtn);
         panel.add(deleteBtn);
         panel.add(editBtn);

         /**
         * 设置字体样式和大小
         */
         tree.setFont(new Font("微软雅黑", Font.PLAIN, 18));
         addChildBtn.setFont(new Font("微软雅黑", Font.PLAIN, 18));
         deleteBtn.setFont(new Font("微软雅黑", Font.PLAIN, 18));
         editBtn.setFont(new Font("微软雅黑", Font.PLAIN, 18));


         this.add(jsp,BorderLayout.CENTER);
         this.add(panel,BorderLayout.SOUTH);
         this.setTitle("Client");
         this.setSize(500,500);
         this.setLocation(200,200);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);

    }
}
