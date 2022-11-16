package itheima11;

import java.util.HashMap;
import java.util.Map;

public class MapDemo01 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("itheima01","林青霞");
        map.put("itheima02","张曼玉");
        map.put("itheima03","王祖贤");
        map.put("itheima03","柳岩");

        //输出集合对象
        System.out.println(map);
    }
}
