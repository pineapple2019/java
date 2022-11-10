import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9};


        int[] b = Arrays.copyOfRange(a,1,6);

        for (int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
        System.out.println("b的长度:"+b.length);
    }
}

