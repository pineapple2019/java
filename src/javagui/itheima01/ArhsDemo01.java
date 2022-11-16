package itheima01;

public class ArhsDemo01 {
    public static void main(String[] args) {
        System.out.println(sum(10,20));
        System.out.println(sum(10,20,30));
        System.out.println(sum(10,20,30,40));
        System.out.println(sum(10,20,30,40,50));
    }

    /*
    public static int sum(int... a){
//        System.out.println(a);
        int sum=0;
        for(int i:a){
            sum+=i;
        }
        return sum;
    }
*/
    public static int sum(int b,int... a) {
        return 0;//这样会首先给b，然后剩余的给a
    }


}
