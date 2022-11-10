//import java.text.MessageFormat;
//
//import com.sun.org.slf4j.internal.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import java.util.logging.Logger;
//
//public class Demo {
//    protected static final Logger log = LoggerFactory.getLogger(Demo.class.getName());
//
//    private MessageFormat format;
//
//    public Demo(String placeholder) {
//        super();
//        this.format = new MessageFormat(placeholder);//包含占位符的字符串
//    }
//
//    public void getStrMsg(String ...strMsg) {
//        log.info(format.format(strMsg));//格式化占位符中的内容到目标字符串
//    }
//
//
//
//}