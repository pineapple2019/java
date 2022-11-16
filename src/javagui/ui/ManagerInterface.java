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
// * ˼·�����ȣ�����ѡ���ѡ����Ĳ�������Ҫ��ʲô��Ȼ��
// *���ڵ����ͬ�Ĳ���������ת����ͬ��ҳ�棬���������ݣ�
// *
// * */
//public class ManagerInterface{
//    /*
//        �϶��������ȴ����׽���ѽ����Ϊ�����Ҫ�ͷ�������һֱ���ӵģ�����Ҫ���ⴴ������main�����д���
//     */
//
//    JFrame jf = new JFrame("�ͻ���");
//
//    final int WIDTH = 1000;
//    final int HEIGHT = 600;
//
//    public void init() throws IOException {
//        //��������������
//        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
//        jf.setResizable(false);
//        //jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));
//        /*
//            ���ò˵���
//         */
//        JMenuBar jmb = new JMenuBar();
//        JMenu joFile = new JMenu("�ļ�");
//        JMenu jMenu = new JMenu("����");
//
//        JMenuItem openFile = new JMenuItem("���ļ�");
//        JMenuItem saveFile = new JMenuItem("�ļ����Ϊ");
//
//        JMenuItem m2 = new JMenuItem("�˳�����");
//        //�˳���������ʹ�������ڲ���ĺô����ǣ������ٴ��������ˣ�ֱ�ӵ��ø÷�������
//        m2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }//�˳���ǰ����
//        });
//
//        //�˵��ŵ��˵���
//        jmb.add(joFile);
//        jmb.add(jMenu);
//
//        joFile.add(openFile);
//        joFile.add(saveFile);
//        jMenu.add(m2);
//
//        jf.setJMenuBar(jmb);
//
//        //���÷ָ����
//        JSplitPane sp = new JSplitPane();
//        //֧����������
//        sp.setContinuousLayout(true);
//        //��ʼ����һ���ָ�����λ��,�������ң�150�����ؿ�
//        sp.setDividerLocation(150);
//        //���÷ָ����Ŀ��
//        sp.setDividerSize(7);
//
//        //�����������
//        DefaultMutableTreeNode root = new DefaultMutableTreeNode("���彨ģ");
//        DefaultMutableTreeNode userManage = new DefaultMutableTreeNode("�༭����ģ��");
//        DefaultMutableTreeNode bookManage = new DefaultMutableTreeNode("�༭����ģ��");
//        DefaultMutableTreeNode borrowManage = new DefaultMutableTreeNode("OntoGraf");
////      DefaultMutableTreeNode statisticsManage = new DefaultMutableTreeNode("ͳ�Ʒ���");
//
//        root.add(userManage);
//        root.add(bookManage);
//        root.add(borrowManage);
////        root.add(statisticsManage);
//
//        //����ɫ
//        Color color = new Color(203,220,217);
//
//        JTree tree = new JTree(root);
//        MyRenderer myRenderer = new MyRenderer();
//
//        //  �ڵ����������ѡ��ʱ������ɫ��δѡ��ʱ����������ɫ
//        myRenderer.setBackgroundNonSelectionColor(color);
//        myRenderer.setBackgroundSelectionColor(new Color(140,140,140));
//        tree.setCellRenderer(myRenderer);
//
//        //���ñ���ɫ
//        tree.setBackground(color);
//
//        tree.setSelectionRow(2);    //���õ�ǰtreeĬ��ѡ��ͼ�����
//
//        //���ѡ�Ĳ�һ�����ұ���ʾ��Ҳ��һ��������Ҫ���������Ŀ��ѡ��״��
//        tree.addTreeSelectionListener(new TreeSelectionListener() {
//            //����Ŀѡ�б仯�����������ִ��
//            @Override
//            public void valueChanged(TreeSelectionEvent e) {
//                //�õ���ǰѡ�еĽ�����
//                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();
//
//                if (userManage.equals(lastPathComponent)){
////                    sp.setRightComponent(new JLabel("����ģ�͹���"));
////                    sp.setRightComponent(new BookManageComponent(jf,s));
//
////                    sp.setRightComponent(new BookManageComponent(jf));
//                    sp.setRightComponent(new EditTree());
////                    EditTree
//
//                    sp.setDividerLocation(150);
//                }else if (bookManage.equals(lastPathComponent)){
//                    sp.setRightComponent(new BookManageComponent(jf));
////                    sp.setRightComponent(new JLabel("���༭"));
//
//
//                    sp.setDividerLocation(150);
//                } if (borrowManage.equals(lastPathComponent)){
//                    sp.setRightComponent(new JLabel("ģ��չʾ"));
//                    sp.setDividerLocation(150);
//                }
////                if (statisticsManage.equals(lastPathComponent)){
////                    sp.setRightComponent(new JLabel("�������ͳ�Ʒ���..."));
////                    sp.setDividerLocation(150);
////                }
//
//            }
//        });
//
//        //�����ұ������
//        sp.setRightComponent(new BookManageComponent(jf));
////        sp.setRightComponent(new BookManageComponent(jf,s));
//        //�������Ϊ��
//        sp.setLeftComponent(tree);
//        jf.add(sp);
//        jf.setVisible(true);
////        jf.add(sp);
////        jf.setVisible(true);
//    }
//
//    //�Զ����������
//    private class MyRenderer extends DefaultTreeCellRenderer {
//        private ImageIcon rootIcon = null;  //���Ǻ��Ǹ����й�
//
//        private ImageIcon userManageIcon = null;
//        private ImageIcon bookManageIcon = null;
//        private ImageIcon borrowManageIcon = null;
//        private ImageIcon statisticsManageIcon = null;
//        //���캯��
//        public MyRenderer() {
//            rootIcon = new ImageIcon(PathUtils.getRealPath("systemManage.png"));
//            userManageIcon = new ImageIcon(PathUtils.getRealPath("userManage.png"));
//            bookManageIcon = new ImageIcon(PathUtils.getRealPath("bookManage.png"));
//            borrowManageIcon = new ImageIcon(PathUtils.getRealPath("borrowManage.png"));
//            statisticsManageIcon = new ImageIcon(PathUtils.getRealPath("statisticsManage.png"));
//        }
//
//        //����������ÿ�����ʱ����������������,�����������д�ķ���
//        @Override
//        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus)
//        {                       //�������row������ֻ��ǰ����ʱ���ڼ����ڵ�
//            //ϵͳ�����0�����û������1�������ʿ�����switch�ж�һ��
//            //ʹ��Ĭ�ϻ���
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
//            return this;    //��Ϊ���������Ĭ�ϵĽڵ����jlabel���������ǿ���ֱ�Ӱѽڵ㷵��
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//
////        �����ͻ��˵�Socket����(Socket)
////        Socket s = new Socket("localhost", 10100);
//        new ManagerInterface().init();
////            new ManagerInterface().init(s);
//    }
//}