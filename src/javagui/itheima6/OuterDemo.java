package itheima6;

class Outer{
    private int num = 20;
    public void method(){
        int num2=20;
        class Inner{
            public void show(){
                System.out.println(num);
                System.out.println(num2);
            }
        }
        Inner i=new Inner();
        i.show();
    }
}

public class OuterDemo {
    public static void main(String[] args) {
        Outer outer=new Outer();
        outer.method();
    }
}
