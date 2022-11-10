import java.text.MessageFormat;

/**
 * @Author: 从南到北
 * @Date: 2022/03/10/22:17
 */
public class MessageFormatDemo3 {
    public static void main(String[] args) {

        int fileCount = 1273;

        String diskName = "MyDisk";

        Object[] testArgs = {new Long(fileCount), diskName};

        MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0} file(s).");

        System.out.println(form.format(testArgs));

    }
}
