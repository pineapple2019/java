package 重新;

import java.util.Iterator;

/**
 * @Author: 从南到北
 * @Date: 2022/01/04/23:08
 */
public class Stack<T> implements Iterable<T> {
    private Node head;
    private int N;

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
            private Node n;

            public SIterator() {
                this.n = head;
            }

            @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
                n= n.next;
            return n.item;
        }
    }

    //内部节点类
    private class Node{

        public T item;
        public Node next;
        //构造函数
        public Node(T item,Node next){
            this.item = item;
            this.next=next;
        }
    }



    public Stack(){

        this.head = new Node(null,null);
        this.N=0;
    }

    //判断栈是否为空
    public Boolean isEmpty(){
        return N==0;
    }

    //获取栈中元素个数

    public int size(){
        return N;
    }

    //压栈
    public void push(T t){
        //链表
        Node OldFirst = head.next;

        Node newNode = new Node(t,null);

        head.next=newNode;

        newNode.next=OldFirst;

        N++;
    }

    //出栈，这个不是和压栈刚好相反吗，就是对链表的操作也是相反的

    public T pop(){
//        首先判断栈是否为空，若为空，直接返回,怎么判断
        //找到首节点指向的第一个节点
        Node oldFirst = head.next;
        if (oldFirst==null)
        {
            return null;
        }
        head.next = oldFirst.next;
        N--;
        return oldFirst.item;
    }

//    遍历栈







}
