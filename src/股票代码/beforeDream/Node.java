package beforeDream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ���ϵ���
 * @Date: 12/02/2021/19:28
 * @Description:
 */
public class Node {

    //����
    int data;
    //��һ���ڵ�
    Node next;
    Node before;
    //����һ���޲������췽�������ڳ�ʼ��

    public Node(){

    }

    //����һ���в������췽�������ڸ���㴫����
    public Node(int data){
        this.data=data;
    }

}
