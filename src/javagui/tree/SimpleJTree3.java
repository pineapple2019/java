package tree;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class SimpleJTree3
{
    JFrame jf = new JFrame("����");
    JTree tree;
    //���弸����ʼ���
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("�й�");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("�㶫");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("����");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("��ɽ");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("��ͷ");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("����");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("����");

    //���尴ť����ɲ���
    JButton addSiblingBtn = new JButton("����ֵܽ��");
    JButton addChildBtn = new JButton("����ӽ��");
    JButton deleteBtn = new JButton("ɾ�����");
    JButton editBtn = new JButton("�༭��ǰ���");

    public void init(){

        //ͨ��add()�����������Ӳ㼶��ϵ
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);


        //���ݸ��ڵ㣬������JTree
        tree = new JTree(root);

//jTree�������TreeModel����ģ�Ͷ���




        tree.putClientProperty( "JTree.lineStyle", "None");  //���ý��֮��û��������
//      tree.putClientProperty("JTree.lineStyle" , "Horizontal");   //���ý��֮��ֻ��ˮƽ�ָ���
        tree.setShowsRootHandles(true);     //���ø������"չ�����۵�"ͼ��
        tree.setRootVisible(false);         //���ظ����


//      jf.add(new JScrollPane(tree));
        jf.add(tree);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setBounds(666,666,400,500);  //����������jf���
//      jf.pack();
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleJTree3().init();
    }
}
