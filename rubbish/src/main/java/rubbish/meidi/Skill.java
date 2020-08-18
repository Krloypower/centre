package rubbish.meidi;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @ClassName Skill
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-09-09 15:44
 **/
public class Skill {

    static JSONObject body;
    static {
        body = new JSONObject();
        body.put("vserion","0.2.0");

        JSONObject request = new JSONObject();
        request.put("type","IntentRequest");
        JSONObject nlu = new JSONObject();
        JSONObject slots = new JSONObject();
        JSONObject nluSlots = new JSONObject();
        nluSlots.put("classifier","mideaDomain");
        slots.put("nlu", nluSlots);
        nlu.put("slots",slots);
        nlu.put("domain","mideaDomain");
        nlu.put("intent","transmit");
        nlu.put("english_domain","mideaDomain");

        request.put("nlu",nlu);
        JSONObject asr = new JSONObject();
        asr.put("text","打开厨房热水器");
        request.put("asr",asr);
        body.put("request",request);

        JSONObject session = new JSONObject();
        session.put("sessionId","48c92becaf4a7b6b4218d42ad318bd1a");
        JSONObject attributes = new JSONObject();
        attributes.put("a","b");
        attributes.put("c","d");
        session.put("attributes",attributes);
        JSONObject application = new JSONObject();
        JSONObject client = new JSONObject();
        client.put("clientId","orion.ovs.client.1507867446289");
        JSONObject ucenter = new JSONObject();
        // 美的系统（OVS）客户端关联的用户中心ClientID
        ucenter.put("clientId","0e215b2bc3f6cfa41cc3bfdc845b890c");
        // 美的系统（OVS）客户端关联的用户中心Secret
        ucenter.put("secret","2cddc204b428ef114e29664704698dcd");
        client.put("ucenter",ucenter);
        application.put("client",client);
        JSONObject skill = new JSONObject();

        skill.put("skillId","orion.ovs.skill.1540972223847");
        JSONObject linkAccount = new JSONObject();
        JSONObject linkAccoutTemp = new JSONObject();
        linkAccoutTemp.put("third_access_token","Tx9x6meqcjk2dqih");
        linkAccoutTemp.put("bind",1);
        linkAccoutTemp.put("third_uid","obff4da4ab9e711e2972586000000000");
        linkAccoutTemp.put("third_refresh_token","3bfef0398eba46948bf48205106b8e9a");
        linkAccoutTemp.put("type","fusion_msmart");
        linkAccount.put("orion.ovs.rsplatform.1488857923",linkAccoutTemp);
        skill.put("linkAccount",linkAccount);
        skill.put("skillStatus","online");
        application.put("skill",skill);
        session.put("application",application);

        JSONObject user = new JSONObject();
        user.put("isLogin",true);
        user.put("openId","d250f4422747c0dc2ab36c3ddf8c6f02");
        user.put("userId","1641790");
        user.put("voiceprintExists",false);
        user.put("voiceprintPay",false);
        user.put("unionAccessToken","eyJhbGciOiJIUzI1NiJ9.eyJjbGllbnRJZCI6Im9yaW9uLnVjZW50ZXIuYzZjYmJkOWRhYWE2NDI1YSIsIm9wZW5JZCI6ImQyNTBmNDQyMjc0N2MwZGMyYWIzNmMzZGRmOGM2ZjAyIiwic2NvcGUiOiJvdnM6ZGV2aWNlIiwiaXNzIjoib3Jpb24iLCJleHAiOjE1NjgwMjcyNDgsInR5cGUiOiJhY2Nlc3NfdG9rZW4iLCJpYXQiOjE1NjgwMjAwNDgsInZlcnNpb24iOiIxLjAifQ.7UXoCPo9PKzEED3178n7wZNMhk9ZGqzNyqh3QCchmGc");
        session.put("user",user);
        body.put("session",session);

        JSONObject context = new JSONObject();
        JSONObject System = new JSONObject();
        JSONObject device = new JSONObject();
        device.put("deviceType","2");
        device.put("deviceId","00001");
        device.put("lat","36.032073");
        device.put("lng","114.999427");
        device.put("osType","0");
        device.put("version","1.0.0");

        JSONObject params = new JSONObject();
        params.put("lng","114.999427");
        params.put("os_version","1.2.8");
        params.put("device_type",2);
        params.put("deviceid","1110000102130196282551");
        params.put("version","1.0.0");
        params.put("client_id","orion.ovs.client.1507867446289");
        params.put("dt",7);
        params.put("ovs_sdk_version","0.2.18");
        params.put("union_access_token","eyJhbGciOiJIUzI1NiJ9.eyJjbGllbnRJZCI6Im9yaW9uLnVjZW50ZXIuYzZjYmJkOWRhYWE2NDI1YSIsIm9wZW5JZCI6ImQyNTBmNDQyMjc0N2MwZGMyYWIzNmMzZGRmOGM2ZjAyIiwic2NvcGUiOiJvdnM6ZGV2aWNlIiwiaXNzIjoib3Jpb24iLCJleHAiOjE1NjgwMjcyNDgsInR5cGUiOiJhY2Nlc3NfdG9rZW4iLCJpYXQiOjE1NjgwMjAwNDgsInZlcnNpb24iOiIxLjAifQ.7UXoCPo9PKzEED3178n7wZNMhk9ZGqzNyqh3QCchmGc");
        params.put("user_id","1641790");
        params.put("ovs_sdk_os","linux");
        params.put("os_type","0");
        params.put("model","MOBE-VA013");
        params.put("lat","36.032073");
        System.put("device",device);
        System.put("params",params);
        context.put("System",System);
        body.put("context",context);
    }

    public static String skill() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "http://sit.aimidea.cn:11003/v1/orion/skill/invoke";
        HttpPost post = new HttpPost(url);
        StringEntity entity = new StringEntity(JSONObject.toJSONString(body, SerializerFeature.MapSortField),"UTF-8");
        post.setEntity(entity);
        post.setHeader("Content-Type","application/json");
        HttpResponse response = httpClient.execute(post);
        return EntityUtils.toString(response.getEntity());
    }

    public static void main(String[] args) {
        try {
            System.out.println(skill());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
