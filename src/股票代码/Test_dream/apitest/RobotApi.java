package Test_dream.apitest;

public class RobotApi {
    private static final String ROBOT_API_HOST = "http://openapi.tuling123.com/openapi/api/v2";
    private String key;
    private String userid;

    public RobotApi(String key, String userid) {
        super();
        this.key = key;
        this.userid = userid;
    }

    private String buildParams(String Word) {
        String a = "{\"reqType\":0,\"perception\": {\"inputText\": {\"text\": \"";
        String b = "\"}},\"userInfo\": {\"apiKey\": \"";
        String c = "\",\"userId\": \"";
        String d = "\"}\r\n" + "}";
        String string = a + Word + b + key + c + userid + d;
        return string;

    }

    public String getRobotResult(String Word) {

        return HttpPost.doPost(ROBOT_API_HOST, buildParams(Word));
    }
}

