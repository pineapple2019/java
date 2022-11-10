package dream0519.dream4;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * java保留两位小数
 */
public class two_decimal {
    //向下取整，并保留两位小数
    public static void main(String[] args) {
        double value = 2528.439;

        System.out.println(func1(value));//2528.44
       func2();
       func3();

    }

    private static void func3() {
        double d = 3.1415926;

        String result = String .format("%.2f");
        System.out.println(result);
        //2f表示 小数点前任意位数   2 表示两位小数 格式后的结果为f 表示浮点型
    }

    private static void func2() {
        double   f   =   111231.5585;

        BigDecimal   b   =   new   BigDecimal(f);

        double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);//111231.56
    }

    private static double func1(double param) {
        DecimalFormat df = new DecimalFormat("0.00");
        String res = df.format(param);
        double ans = Double.parseDouble(res);
        return ans;
    }




}
