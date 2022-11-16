//package ui;
//
//import component.BookManageComponent;
//import tree.EditTree;
//import util.PathUtils;
//import util.ScreenUtils;
//
//import javax.swing.*;
//import javax.swing.event.TreeSelectionEvent;
//import javax.swing.event.TreeSelectionListener;
//import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.tree.DefaultTreeCellRenderer;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.IOException;
//import java.net.Socket;
//
//
///*
// * 思路，首先，下拉选择框，选择你的操作，你要做什么，然后，
// *对于点击不同的操作，会跳转到不同的页面，请输入内容，
// *
// * */
//public class ManagerInterface{
//    /*
//        肯定是在首先创建套接字呀，因为这个是要和服务器端一直连接的，所以要在这创建，在main函数中创建
//     */
//
//    JFrame jf = new JFrame("客户端");
//
//    final int WIDTH = 1000;
//    final int HEIGHT = 600;
//
//    public void init() throws IOException {
//        //给窗口设置属性
//        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
//        jf.setResizable(false);
//        //jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));
//        /*
//            设置菜单栏
//         */
//        JMenuBar jmb = new JMenuBar();
//        JMenu joFile = new JMenu("文件");
//        JMenu jMenu = new JMenu("设置");
//
//        JMenuItem openFile = new JMenuItem("打开文件");
//        JMenuItem saveFile = new JMenuItem("文件另存为");
//
//        JMenuItem m2 = new JMenuItem("退出程序");
//        //退出程序函数，使用匿名内部类的好处就是，不用再创建对象了，直接调用该方法即可
//        m2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }//退出当前程序
//        });
//
//        //菜单放到菜单条
//        jmb.add(joFile);
//        jmb.add(jMenu);
//
//        joFile.add(openFile);
//        joFile.add(saveFile);
//        jMenu.add(m2);
//
//        jf.setJMenuBar(jmb);
//
//        //设置分割面板
//        JSplitPane sp = new JSplitPane();
//        //支持连续布局
//        sp.setContinuousLayout(true);
//        //初始设置一个分隔条的位置,从左往右，150个像素宽
//        sp.setDividerLocation(150);
//        //设置分隔条的宽度
//        sp.setDividerSize(7);
//
//        //设置左侧内容
//        DefaultMutableTreeNode root = new DefaultMutableTreeNode("本体建模");
//        DefaultMutableTreeNode userManage = new DefaultMutableTreeNode("编辑本体模型");
//        DefaultMutableTreeNode bookManage = new DefaultMutableTreeNode("编辑本体模型");
//        DefaultMutableTreeNode borrowManage = new DefaultMutableTreeNode("OntoGraf");
////      DefaultMutableTreeNode statisticsManage = new DefaultMutableTreeNode("统计分析");
//
//        root.add(userManage);
//        root.add(bookManage);
//        root.add(borrowManage);
////        root.add(statisticsManage);
//
//        //背景色
//        Color color = new Color(203,220,217);
//
//        JTree tree = new JTree(root);
//        MyRenderer myRenderer = new MyRenderer();
//
//        //  节点控制器，当选中时，是绿色，未选中时，是其他颜色
//        myRenderer.setBackgroundNonSelectionColor(color);
//        myRenderer.setBackgroundSelectionColor(new Color(140,140,140));
//        tree.setCellRenderer(myRenderer);
//
//        //设置背景色
//        tree.setBackground(color);
//
//        tree.setSelectionRow(2);    //设置当前tree默认选中图书管理
//
//        //左边选的不一样，右边显示的也不一样，所以要监听左边条目的选中状况
//        tree.addTreeSelectionListener(new TreeSelectionListener() {
//            //当条目选中变化后，这个方法会执行
//            @Override
//            public void valueChanged(TreeSelectionEvent e) {
//                //得到当前选中的结点对象
//                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();
//
//                if (userManage.equals(lastPathComponent)){
////                    sp.setRightComponent(new JLabel("本体模型构建"));
////                    sp.setRightComponent(new BookManageComponent(jf,s));
//
////                    sp.setRightComponent(new BookManageComponent(jf));
//                    sp.setRightComponent(new EditTree());
////                    EditTree
//
//                    sp.setDividerLocation(150);
//                }else if (bookManage.equals(lastPathComponent)){
//                    sp.setRightComponent(new BookManageComponent(jf));
////                    sp.setRightComponent(new JLabel("待编辑"));
//
//
//                    sp.setDividerLocation(150);
//                } if (borrowManage.equals(lastPathComponent)){
//                    sp.setRightComponent(new JLabel("模型展示"));
//                    sp.setDividerLocation(150);
//                }
////                if (statisticsManage.equals(lastPathComponent)){
////                    sp.setRightComponent(new JLabel("这里进行统计分析..."));
////                    sp.setDividerLocation(150);
////                }
//
//            }
//        });
//
//        //设置右边是组件
//        sp.setRightComponent(new BookManageComponent(jf));
////        sp.setRightComponent(new BookManageComponent(jf,s));
//        //左边设置为树
//        sp.setLeftComponent(tree);
//        jf.add(sp);
//        jf.setVisible(true);
////        jf.add(sp);
////        jf.setVisible(true);
//    }
//
//    //自定义结点绘制器
//    private class MyRenderer extends DefaultTreeCellRenderer {
//        private ImageIcon rootIcon = null;  //这是和那个树有关
//
//        private ImageIcon userManageIcon = null;
//        private ImageIcon bookManageIcon = null;
//        private ImageIcon borrowManageIcon = null;
//        private ImageIcon statisticsManageIcon = null;
//        //构造函数
//        public MyRenderer() {
//            rootIcon = new ImageIcon(PathUtils.getRealPath("systemManage.png"));
//            userManageIcon = new ImageIcon(PathUtils.getRealPath("userManage.png"));
//            bookManageIcon = new ImageIcon(PathUtils.getRealPath("bookManage.png"));
//            borrowManageIcon = new ImageIcon(PathUtils.getRealPath("borrowManage.png"));
//            statisticsManageIcon = new ImageIcon(PathUtils.getRealPath("statisticsManage.png"));
//        }
//
//        //当绘制树的每个结点时，都会调用这个方法,这个是真正重写的方法
//        @Override
//        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus)
//        {                       //这个参数row，就是只当前绘制时，第几个节点
//            //系统管理第0个，用户管理第1个。，故可以用switch判断一下
//            //使用默认绘制
//            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
////            Image image=null;
//            ImageIcon image = null;
//
//            switch (row) {
//                case 0:
//                    image = rootIcon;
//                    break;
//                case 1:
//                    image = userManageIcon;
//                    break;
//                case 2:
//                    image = bookManageIcon;
//                    break;
//                case 3:
//                    image = borrowManageIcon;
//                    break;
//                case 4:
//                    image = statisticsManageIcon;
//                    break;
//            }
//
//            this.setIcon(image);
//            return this;    //因为树的组件，默认的节点就是jlabel，所以我们可以直接把节点返回
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//
////        创建客户端的Socket对象(Socket)
////        Socket s = new Socket("localhost", 10100);
//        new ManagerInterface().init();
////            new ManagerInterface().init(s);
//    }
//}