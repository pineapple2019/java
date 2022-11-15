package 重新;

/**
 * @Author: 从南到北
 * @Date: 2022/01/06/20:29
 */
public class bugTest {

	public static void main(String[] args) {
		String str = "123456789";//字符串长度是9
		String tempStr = str.substring(0, 10);//一定报错：String index out of range: 10
	}

}
