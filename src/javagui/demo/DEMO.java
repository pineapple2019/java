package demo;

class FU{
    //ÄêÁä
    public int age=40;
}

class ZI extends FU{
    public int height = 175;
    public int age=20;
    public void show(){
        int age=30;
        System.out.println(age);
        System.out.println(height);
    }
}

public class DEMO {
    public static void main(String[] args) {
        ZI Z=new ZI();
        Z.show();
    }
}
