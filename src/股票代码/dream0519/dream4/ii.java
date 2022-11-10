package dream0519.dream4;

public class ii {
    public static void main(String[] args) {
       double a = Transfer_tax(30,0.2);
        System.out.println(a);
        int a1=1,b=4;
        ex(a1,b);
        System.out.println(a1);
        System.out.println(b);
    }

    private static double Transfer_tax(double turnover,double rate){
        double tax = turnover * rate;
        return tax;
    }
    private static void ex(int a,int b){
        int temp=0;
        temp =a;
        a=b;
        b=temp;
    }
}
