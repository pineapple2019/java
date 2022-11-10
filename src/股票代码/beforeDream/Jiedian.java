package beforeDream;

public class Jiedian implements LinkList {
    // Node root=new Node();
    Node head = new Node();// ????
    // ¦Â???
    Node tail;
    // ??????
    // Node next;
    int size;
    private int data;

    public Jiedian() {
        // ??????????¦Â???
        head = new Node();
        tail = head;
        size = 0;
    }

    public void check(int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("????????");
        }

    }

    public void add(int e) {

        // ???????????
        // next=new Node(obj);
        // if(size==0){
        // // root.
        // }
        Node node = new Node(e);
        // ¦Â???????????????????
        tail.next = node;
        // ???¦Â?????????
        tail = node;
        // ?????????
        size++;

    }

    public void insert(int e, int index) {
        check(index);
        Node node1 = head.next;
        for (int i = 0; i < index; i++) {
            node1 = node1.next;// ???index???
        }
        Node node2 = new Node(e);
        if (index == 0) {// ????????????
            head.next = null;// ???????????????
            head.next = node2;// ??????????????
            node2.next = node1;// ????????????????
        } else {
            Node node3 = head.next;
            for (int i = 0; i < index - 1; i++) {
                node3 = node3.next;
            }
            node3.next = null;
            node3.next = node2;
            node2.next = node1;

        }
        size++;
    }

    public void delete(int index) {
        check(index);
        // ?¡À??index????
        Node node1 = head.next;
        if (index != 0) {
            for (int i = 0; i < index; i++) {
                node1 = node1.next;

            }
            // ?¡À??index-1????index?????????
            Node node2 = head.next;
            for (int i = 0; i < index - 1; i++) {
                node2 = node2.next;
            }
            if (index != size - 1) {// ????????????????
                Node node3 = node1.next;// index??????????
                node2.next = node3;// ???????????????????
                node1.next = null;// ???????????index???
            } else {
                node1.next = null;// ???????????index???
            }
            node1 = null;
            // node1.next=null;
        } else {
            Node node6 = head.next;
            Node node7 = node6.next;
            head.next = null;
            head.next = node7;
            node6.next = null;

        }
        size--;
    }

    public int get(int index) {

        Node node = head.next;
        // ???????????????????
        for (int i = 0; i < index; i++) {
            node = node.next;

        }
        return node.data;
    }

    @Override
    public void set(int data) {

    }

    public void updata(int index, int e) {

        Node node1 = head.next;
        for (int i = 0; i < index; i++) {

            node1 = node1.next;

        }

        node1.data = e;

    }

    public int getSize() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public Node getNext() {
        return null;
    }

    @Override
    public void setNext(Node next) {

    }

    public static void main(String[] args) {
        // ????????
        Jiedian kk = new Jiedian();
        // ??????
        kk.add(55);
        kk.add(89);
        kk.add(18);
        kk.add(92);
        kk.add(562);
        kk.add(782);
        kk.add(45);
        kk.delete(4);
        kk.insert(666, 3);
        kk.updata(4, 5555);
        for (int i = 0; i < kk.getSize(); i++) {
            int e = kk.get(i);
            System.out.println("??" + i + "????????" + e);
        }

    }
}