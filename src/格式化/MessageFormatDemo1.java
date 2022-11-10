import java.text.MessageFormat;
import java.util.Date;

/**
 * @Author: 从南到北
 * @Date: 2022/03/10/21:50
 */
public class MessageFormatDemo1 {
    public static void main(String[] args) {
        Object[] arguments = {new Integer(7),new Date(System.currentTimeMillis()),"confidence"};

        String result = MessageFormat.format("at {1,time} on {1,date},there was {2} on planet{0,number,integer}.",arguments);
        System.out.println(result);

     }
}
