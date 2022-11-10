//package Test_dream.apitest;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//import java.util.Scanner;
//
//public class Main {
//    private static final String apiKey = "自己的key";
//    private static final String userId = "自己的id";
//
//    public static void main(String[] args) {
//        RobotApi api = new RobotApi(apiKey, userId);
//        while (true) {
//
//            Scanner input = new Scanner(System.in);
//
//            String word = input.next();
//            String backString = api.getRobotResult(word);
//
//            JSONObject jsonobj = JSON.parseObject(backString);
//            JSONArray result = jsonobj.getJSONArray("results");
//            for (int i = 0; i < result.size(); i++) {
//                System.out.println(result.getJSONObject(0).getJSONObject("values").getString("text"));
//            }
//        }
//    }
//
//}
