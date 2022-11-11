package 格式化;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @Author: 从南到北
 * @Date: 2022/03/10/21:57
 */


//

public class MessageFormatDemo2 {
    public static void main(String[] args) {
        int planet = 35;

        String event = "a disturbance in the force";

        String result = MessageFormat.format("At {1,time} on {1,date}, there was {2} on cao {0,number,integer}.",
                planet, new Date(), event);

        System.out.println(result);

    }
}
