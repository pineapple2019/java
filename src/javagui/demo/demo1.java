package demo;

public class demo1 extends FU{
    public int age=20;
    public void show(){
        int age=30;
        //访问的是内部变量
        System.out.println(age);
        //访问的是本类的成员变量
        System.out.println(this.age);
        //访问父类成员变量//父类中age是40
        System.out.println(super.age);
    }

    public static void main(String[] args) {
        new demo1().show();
    }
}
