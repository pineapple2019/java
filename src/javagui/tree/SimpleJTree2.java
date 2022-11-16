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
    //������Ҫ���϶���TreePath
    TreePath movePath;

    //���尴ť����ɲ���
    JButton addSiblingBtn = new JButton("����ֵܽ��");
    JButton addChildBtn = new JButton("����ӽ��");
    JButton deleteBtn = new JButton("ɾ�����");
    JButton editBtn = new JButton("�༭��ǰ���");
    public void init(){

        //�ĸ�����
        //�����������ڵ�
        DefaultMutableTreeNode root =new DefaultMutableTreeNode("owl��Thing");
        DefaultMutableTreeNode guangDong =new DefaultMutableTreeNode("������Դ");
        DefaultMutableTreeNode guangXi =new DefaultMutableTreeNode("�洢��Դ");

        DefaultMutableTreeNode foShan =new DefaultMutableTreeNode("������Դ");
        DefaultMutableTreeNode shanTou =new DefaultMutableTreeNode("������Դ");
        DefaultMutableTreeNode guiLin =new DefaultMutableTreeNode("������Դ");
        DefaultMutableTreeNode guiLin1 =new DefaultMutableTreeNode("������");
        DefaultMutableTreeNode guiLin2 =new DefaultMutableTreeNode("�״�");
        DefaultMutableTreeNode guiLin3 =new DefaultMutableTreeNode("����");
        DefaultMutableTreeNode guiLin4 =new DefaultMutableTreeNode("����");
        DefaultMutableTreeNode guiLin5 =new DefaultMutableTreeNode("����");
        DefaultMutableTreeNode guiLin6 =new DefaultMutableTreeNode("����");
        DefaultMutableTreeNode guiLin7 =new DefaultMutableTreeNode("��Ϣ������");
        DefaultMutableTreeNode guiLin8 =new DefaultMutableTreeNode("����ƵͨѶ");
        DefaultMutableTreeNode guiLin10 =new DefaultMutableTreeNode("��ƵͨѶ");
        DefaultMutableTreeNode guiLin11 =new DefaultMutableTreeNode("�����");
        DefaultMutableTreeNode guiLin12 =new DefaultMutableTreeNode("�����");

//        DefaultMutableTreeNode nanNing =new DefaultMutableTreeNode("����");
        //��װ�ڵ�֮��Ĺ�ϵ
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

//������Դ
        foShan.add(guiLin5);
        foShan.add(guiLin6);
        //������Դ
        shanTou.add(guiLin7);
        shanTou.add(guiLin8);
        shanTou.add(guiLin10);
        //������Դ
        guiLin.add(guiLin11);
        guiLin.add(guiLin12);
//        guiLin.add(guiLin10);
        //����JTree����
        JTree tree = new JTree(root);
        //��JTree���뵽�����н���չʾ

        //������ڵ�༭����
        tree.setEditable(true);
//        TreeModel model = tree.getModel();
        DefaultTreeModel model = (DefaultTreeModel)tree.getModel(); //ǿ��ת������������ʹ��API

        //�������
        addSiblingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //����ֵܽڵ��߼�

                //1����ȡ��ǰѡ�еĽڵ�
            DefaultMutableTreeNode selectedNode=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

            if (selectedNode==null){
                return;
            }
                //2����ȡ��ǰ�ڵ�ĸ��ڵ�

                //3�������½ڵ�
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("�½ڵ�");
            selectedNode.add(newNode);
                //4,���½ڵ�ͨ�����ڵ㣬�������

                //5����ʾ�½ڵ�
                TreeNode[] pathToRoot = model.getPathToRoot(newNode);
                TreePath treePath = new TreePath(pathToRoot);
                tree.scrollPathToVisible(treePath);
                //6���ػ�tree


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
