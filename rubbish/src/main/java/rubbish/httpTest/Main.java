package rubbish.httpTest;


import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-08-26 19:36
 **/
public class Main {

    public static String params;

    public static void main(String[] args) throws Exception {
        initParams();
        test();
    }

    public static void test(){
        OkHttpClient okHttpClient = new OkHttpClient();
        String sid = UUID.randomUUID().toString();
        String path = "http://api.ximalaya.com/smart-os-gateway/smart-os-openapi/smart-search?q=三角龙与小盗龙的故事&paid_filter=false&copyright_filter=false&uid=79452526&sid="+sid +"&session=%7b%22attributes%22%3a%7b%22a%22%3a%22b%22%7d%2c%22sid%22%3a%22857a0ce6e5dd507b958f12995eb514e4%22%7d&params="+params+"&sig=d113137e3e36cc5e688f0caf8c2efc66&aotuman=true";

        Request request = new Request.Builder()
                .url(path)
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
            //http状态码
            System.out.println(response.code());
            //response的头信息
            System.out.println(response.headers().toString());
            //请求响应时间，收到时间减去发送的时间，单位毫秒
            System.out.println(response.receivedResponseAtMillis()-response.sentRequestAtMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initParams() throws Exception{
        String path = "http://api.ximalaya.com/smart-os-gateway/xy-os-ucenter/account/guest-login";

        // 2 创建okhttpclient对象
        OkHttpClient client = new OkHttpClient();

        String param = "{\"appVersion\":\"2.1.3\",\"childMode\":false,\"deviceId\":\"8d3e29b09d905002\",\"deviceType\":2,\"dt\":1561347428,\"ip\":\"111.204.31.18\",\"isChildMode\":false,\"lat\":\"\",\"lng\":\"\",\"osAccessToken\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJvcy5jbGllbnQuMDAwMTg3IiwidWlkIjowLCJwcm9kdWN0SWQiOiJTX1BST0QxXzE5MCIsImlzcyI6Inh5LW9zLXVjZW50ZXIiLCJleHAiOjE1NjY4MjY5MzAsImRldmljZUlkIjoiVEVTVDE5OTk5MTEifQ.xHTidjli6rhYr6B8K_8HLTxZb0qVwOAQ2dgNhyHptrw\",\"osClientId\":\"os.client.000187\",\"osOpenId\":\"\",\"productId\":\"S_PROD1_190\",\"romVersion\":\"1.2.0\",\"sn\":\"TEST1999911\",\"speakerVersion\":\"0.3.0\",\"sysType\":1,\"sysVersion\":\"9\",\"uid\":\"19067\",\"xn\":\"\"}";
        JSONObject jsonObject = JSONObject.parseObject(param);

        RequestBody body = new FormBody.Builder().add("params", param).add("sig", "111").add("aotuman","1").build();
        // 3 创建请求方式
        Request request = new Request.Builder().url(path).post(body).build();

        // 4 执行请求操作
        try {
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                String string = response.body().string();
                JSONObject object = JSONObject.parseObject(string);
                jsonObject.put("osAccessToken",object.get("osAccessToken"));
                params = jsonObject.toString();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
