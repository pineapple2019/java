package tree;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimpleJTree1 {

    JFrame jf ;
    JTree tree;

    //JTree����������ģ�Ͷ���
    DefaultTreeModel model;

    //���弸����ʼ���
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("�й�");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("�㶫");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("����");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("��ɽ");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("��ͷ");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("����");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("����");

    //������Ҫ���϶���TreePath
    TreePath movePath;

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

        jf = new JFrame("�ɱ༭������");
        tree = new JTree(root);

        //��ȡJTree����������ģ��TreeModel����
        model = (DefaultTreeModel) tree.getModel();

        //����JTree�ɱ༭
        tree.setEditable(true);

        //��������¼�������
        MouseListener ml = new MouseAdapter() {

            //�������ʱ����ñ��϶��Ľ��
            @Override
            public void mousePressed(MouseEvent e) {
                //�����ҪΨһȷ��ĳ����㣬�����ͨ��TreePath����ȡ
                TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
                if (tp!=null){
                    movePath = tp;
                }
            }

            //�ɿ�����ʾ��ȷ�����������뵽�ĸ����
            @Override
            public void mouseReleased(MouseEvent e) {

                TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
                if (tp!=null && movePath!=null){
                    //��ֹ���ӽ���϶�
                    if (movePath.isDescendant(tp) && movePath!=tp){
                        JOptionPane.showMessageDialog(jf,"Ŀ�����Ǳ��ƶ������ӽ�㣬�޷��ƶ���","�Ƿ��ƶ�",JOptionPane.WARNING_MESSAGE);
                    }
                    //�������ӽ���ƶ���������갴�º��ɿ�Ҳ����ͬһ�����

                    if (movePath!=tp){
                        //add�����ڲ����Ƚ��ý���ԭ�����ɾ����Ȼ���ٰѸý����ӵ��½����
                        DefaultMutableTreeNode tartParentNode = (DefaultMutableTreeNode) tp.getLastPathComponent();
                        DefaultMutableTreeNode moveNode = (DefaultMutableTreeNode) movePath.getLastPathComponent();
                        tartParentNode.add(moveNode);

                        movePath=null;
                        tree.updateUI();
                    }
                }
            }
        };

        //ΪJTree�����������
        tree.addMouseListener(ml);

        JPanel panel = new JPanel();

        addSiblingBtn.addActionListener(e -> {
            //��ȡѡ�н��
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

            //������Ϊ�գ���ֱ�ӷ���
            if (selectedNode==null){
                return;
            }

            //��ȡ��ѡ�н��ĸ����
            DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();

            //��������Ϊ�գ���ֱ�ӷ���
            if (parent==null){
                return;
            }

            //����һ���½��
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("�½��");

            //��ȡѡ�н�������
            int selectedIndex = parent.getIndex(selectedNode);

            //��ѡ��λ�ò����½��
            model.insertNodeInto(newNode,parent,selectedIndex);

            //----------��ʾ�½��---------------
            //��ȡ�Ӹ���㵽�½������н��
            TreeNode[] pathToRoot = model.getPathToRoot(newNode);

            //ʹ��ָ���Ľ�����鴴��TreePath
            TreePath treePath = new TreePath(pathToRoot);

            //��ʾָ����treePath
            tree.scrollPathToVisible(treePath);


        });

        panel.add(addSiblingBtn);

        addChildBtn.addActionListener(e -> {
            //��ȡѡ�н��
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

            if (selectedNode==null){
                return ;
            }

            //�����½��
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("�½��");

            //model.insertNodeInto(newNode,selectedNode,selectedNode.getChildCount());ʹ��TreeModel�ķ�����ӣ�����Ҫ�ֶ�ˢ��UI
            selectedNode.add(newNode);//ʹ��TreeNode�ķ�����ӣ���Ҫ�ֶ�ˢ��UI

            //��ʾ�½��

            TreeNode[] pathToRoot = model.getPathToRoot(newNode);
            TreePath treePath = new TreePath(pathToRoot);
            tree.scrollPathToVisible(treePath);

            //�ֶ�ˢ��UI
            tree.updateUI();

        });

        panel.add(addChildBtn);

        deleteBtn.addActionListener(e -> {

            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

            if (selectedNode!=null && selectedNode.getParent()!=null){
                model.removeNodeFromParent(selectedNode);
            }

        });

        panel.add(deleteBtn);

        //ʵ�ֱ༭���ļ�����
        editBtn.addActionListener(e -> {

            TreePath selectionPath = tree.getSelectionPath();

            if (selectionPath!=null){
                //�༭ѡ�н��
                tree.startEditingAtPath(selectionPath);
            }

        });

        panel.add(editBtn);

        jf.add(new JScrollPane(tree));
        jf.add(panel, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new SimpleJTree1().init();
    }
}
