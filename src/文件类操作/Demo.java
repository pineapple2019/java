package 文件类操作;

class Fu {
    int num = 4;
}
class Zi extends Fu {
    int num = 5;
}
public class Demo {
    public static void main(String[] args) 	{
        Fu f = new Zi();
        System.out.println(f.num);
        Zi z = new Zi();
        System.out.println(z.num);
    }
}