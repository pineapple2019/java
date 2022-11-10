
import java.text.*;
import java.util.*;

public class ceshi {
    public static void main(String[] args) {
        String message1 = "{0}{1}{2}{3}{4}{5}{6}{7}{8}{9}{10}{11}{12}{13}{14}{15}{16}";
        Object[] array1 = new Object[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q"};

        String value1 = MessageFormat.format(message1, array1);

        System.out.println(value1);

        String message2 = "oh, {0} is a cool man";//若用{1}替换{0}则输出为oh, {1} is a cool man
        Object[] array2 = new Object[]{"troye sivan"};
        String value2 = MessageFormat.format(message2, array2);

        System.out.println(value2);

        String message3 = "oh, {0,number,#.#} is a number";//#.#是FormatStyle里的SubformatPattern（子模式）表示保留一位小数
        Object[] array3 = new Object[]{56.125};
        String value3 = MessageFormat.format(message3, array3);

        System.out.println(value3);

        Object[] array4={new Date(),"澳大利亚","晴朗"};
        MessageFormat mf= new MessageFormat("当前时间：{0,time}，地点：{1}，天气：{2}",Locale.US);
        String value4=mf.format(array4);

        System.out.println(value4);

    }

}
