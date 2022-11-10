import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDm1 {
    public static void main(String[] args) {
        /**
         * String str = "[Part 'name=1234567']";
         */
        String targetStr = "where 1=1 [and user_name like '%$user_name$%']  [and company_name like '%$company_name$%']";
        String[] split = targetStr.split("]");
        System.out.println("split==== " + split);
        String patternStr = "^[\\s\\S]{0,}\\[\\s{0,}and\\s{0,}[\\d\\W\\w]{1,}\\s{0,}[\\w]{1,}\\s{0,}\\W{0,}(\\$.+?\\$)\\W{0,}\\s{0,}\\s{0,}$";

        // 正则表达式
        Pattern pattern = Pattern.compile(patternStr);
        // 参数：要匹配的目标字符串
        Map<String,String> map = new HashMap<String,String>();
        map.put("$user_name$","user_value");
        map.put("$company_name$","company_value");
        map.put("$school_name$","$school_name$");
    /*int groupCount = matcher.groupCount();
    System.out.println("groupCount==== " + groupCount);*/
        for (int i = 0;i<=split.length-1;i++) {
            Matcher matcher = pattern.matcher(split[i]);
            System.out.println("split[i]==== " + split[i]);
            boolean b = matcher.find();
            if (b) {
                String key = matcher.group(1);
                for (Map.Entry<String,String> m : map.entrySet()){
                    String mapKey = m.getKey();
                    if (key.equalsIgnoreCase(mapKey)) {
                        System.out.println("key==== " + key );
                    /*String bigGroup = matcher.group();
                    System.out.println("bigGroup==== " + bigGroup);*/
                        targetStr = targetStr.replace(key,m.getValue());
                        // System.out.println("targetStr after replace innner==== " + targetStr);
                    }
                }

            }
            //  System.out.println("targetStr after replace outer==== " + targetStr);
        }
        System.out.println("targetStr after replace final==== " + targetStr);
    }
}
