package beforeDream;

public interface LinkList {


    //�洢
    public void add(int e);
    //����
    public void insert(int e,int index);
    //ɾ��
    public void delete(int index);
    //��ȡ
    public int get(int index);

    public void set(int data);
    //�޸�
    public void updata(int index,int newValue);
    //��ȡԪ�ظ���
    public int getSize();

    public Node getNext();
    public void setNext(Node next);


}