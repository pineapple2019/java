package demo;

public class demo1 extends FU{
    public int age=20;
    public void show(){
        int age=30;
        //���ʵ����ڲ�����
        System.out.println(age);
        //���ʵ��Ǳ���ĳ�Ա����
        System.out.println(this.age);
        //���ʸ����Ա����//������age��40
        System.out.println(super.age);
    }

    public static void main(String[] args) {
        new demo1().show();
    }
}
