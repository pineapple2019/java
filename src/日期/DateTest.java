package 日期;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

public class DateTest {
    @Test
    public void Function(){
        Calendar c = Calendar.getInstance();
        //设置月份，设置到10月份
        c.set(Calendar.MONTH,9);
        //设置年，月，日
        c.set(2099,4,1);
        //获取年份
        int year = c.get(Calendar.YEAR);
        //获取月份
        int month = c.get(Calendar.MONTH)+1;
        //获取天数
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(year+"年"+month+"月"+day+"日");

        Integer integer = new Integer("3333");
        System.out.println(integer);

//        为什么我搞不定

    }
}
