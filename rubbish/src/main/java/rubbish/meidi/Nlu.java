package rubbish.meidi;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @ClassName Nlu
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-09-09 13:48
 **/
public class Nlu {

    static String sign;
    static String random = "ximaNlu";
    static JSONObject body;
    static String content;

    static {
        body = new JSONObject();
        body.put("clientId","0e215b2bc3f6cfa41cc3bfdc845b890c");
        body.put("mid","123123");
        body.put("version","1.0");

        JSONObject request = new JSONObject();
        request.put("timestamp",1540463976528L);
        body.put("request",request);

        JSONObject params = new JSONObject();
        params.put("text","打开洗衣机");
        params.put("pinyin","da ka xi yi ji");
        body.put("params",params);

        JSONObject device = new JSONObject();
        device.put("deviceType","2");
        device.put("deviceId","00001");
        device.put("lat","123");
        device.put("lng","456");
        body.put("device",device);

        String secretkey = "2cddc204b428ef114e29664704698dcd";
        content = body.toString(SerializerFeature.MapSortField);
        sign = DigestUtils.md5Hex(  content + random+ secretkey);

    }

    public static String postnlu() throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "http://sit.aimidea.cn:11003/v1/ai/speech/nlu";
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type","application/json");
//        post.setHeader("accessToken","11");
        post.setHeader("sign",sign);
        post.setHeader("random",random);
        StringEntity stringEntity = new StringEntity(content,"UTF-8");
        post.setEntity(stringEntity);
        HttpResponse response = httpClient.execute(post);
        return EntityUtils.toString(response.getEntity());
    }


    public static void main(String[] args) {
        try {
            System.out.println(postnlu());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
