package dream0519.dream123;

//https://blog.csdn.net/wilson_guo/article/details/8007033
//https://blog.csdn.net/weixin_44167611/article/details/112370212

public class Test_double_float {
    public static void main(String[] args) {
        double d = 2.4;
        System.out.println(d);//2.4
        float f1 = (float) 2.4;
        //使用float，必须强转，或者后面+f
        //float f1 = 2.4;   这样写会报错
        System.out.println(f1);//2.4
        float f2 = 2.4f;
        System.out.println(f2);//2.4
    }
}
