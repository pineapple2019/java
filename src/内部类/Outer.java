package 内部类;

public class Outer {
    int i  = 1;
    class Inner {
        int i  = 2;
        public void inner(){
            int i = 3;
            System.out.println(Outer.this.i);
        }
    }
    public static void main(String[] args) {
        Outer.Inner a = new Outer().new Inner();
        a.inner();
    }
}