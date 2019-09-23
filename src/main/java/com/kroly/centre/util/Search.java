package com.kroly.centre.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName Search
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-08-28 15:04
 **/
@Component
public class Search {

    public void execut() throws Exception {
        String path = "/Users/xmly/Desktop/模糊搜索测试结果.csv";
        FileReader reader = new FileReader(path);
        BufferedReader buffer = new BufferedReader(reader);

        byte[] uft8bom={(byte)0xef,(byte)0xbb,(byte)0xbf};


        FileOutputStream op = new FileOutputStream("/Users/xmly/Desktop/模糊搜索测试结果1.csv");
        op.write(uft8bom);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(op,"UTF-8"));

        String line = buffer.readLine();
        line = line + ",title,id,hittype,sid,pass";
        out.write(line + "\r\n");
        while ((line = buffer.readLine()) != null) {

            String[] split = line.split(",");
            StringBuffer sb = new StringBuffer(line);
            try {
                String album = split[1];
                album = album.substring(album.indexOf(":") + 1);
                String uuid = UUID.randomUUID().toString();
                JSONObject object = sendGet(album, uuid);
                JSONArray albums = object.getJSONArray("search_result_albums");
                String hitType = null;
                Long id = null;
                String title = null;
                String pass = null;
                if (albums != null && albums.size() > 0) {
                    JSONObject jsonObject = albums.getJSONObject(0);
                    hitType = jsonObject.getString("hitType");
                    id = jsonObject.getLong("id");
                    title = jsonObject.getString("title");
                }
                if (Long.valueOf(split[2]).equals(id)) {
                    pass = "pass";
                } else {
                    pass = "fail";
                }
                sb.append(",").append(title).append(",").append(id).append(",").append(hitType).append(",").append(uuid).append(",").append(pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
            out.write(sb + "\r\n");
        }
    }

    public JSONObject sendGet(String album, String sid) throws Exception {
        String url = "http://api.ximalaya.com/smart-os-gateway/smart-os-openapi/smart-search";

        List<NameValuePair> pairs = new ArrayList<>();

        BasicNameValuePair q = new BasicNameValuePair("q", album);
        BasicNameValuePair paid = new BasicNameValuePair("paid_filter", "false");
        BasicNameValuePair copyright = new BasicNameValuePair("copyright_filter", "false");
        BasicNameValuePair sida = new BasicNameValuePair("sid", sid);
        BasicNameValuePair session = new BasicNameValuePair("session", "{\"attributes\":{\"a\":\"b\"},\"sid\":\"857a0ce6e5dd507b958f12995eb514e4\"}");
        BasicNameValuePair sig = new BasicNameValuePair("sig", "d113137e3e36cc5e688f0caf8c2efc66");
        BasicNameValuePair aotuman = new BasicNameValuePair("aotuman", "true");
        BasicNameValuePair params = new BasicNameValuePair("params", "{\"appVersion\":\"2.1.3\",\"childMode\":false,\"deviceId\":\"8d3e29b09d905002\",\"deviceType\":2,\"dt\":1561347428,\"ip\":\"111.204.31.18\",\"isChildMode\":false,\"lat\":\"\",\"lng\":\"\",\"osAccessToken\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJvcy5jbGllbnQuMDAwMTg3IiwidWlkIjowLCJwcm9kdWN0SWQiOiJTX1BST0QxXzE5MCIsImlzcyI6Inh5LW9zLXVjZW50ZXIiLCJleHAiOjE1NjY5ODk2NzksImRldmljZUlkIjoiVEVTVDE5OTk5MTEifQ.DCNA1XWYN9Kb_5aRAXdIY7BfTbb7MY1Lc2vAIgvmUqs\",\"osClientId\":\"os.client.000187\",\"osOpenId\":\"\",\"productId\":\"S_PROD1_190\",\"romVersion\":\"1.2.0\",\"sn\":\"TEST1999911\",\"speakerVersion\":\"0.3.0\",\"sysType\":1,\"sysVersion\":\"9\",\"uid\":\"19067\",\"xn\":\"\"}");
        pairs.add(q);
        pairs.add(paid);
        pairs.add(copyright);
        pairs.add(sida);
        pairs.add(session);
        pairs.add(sig);
        pairs.add(aotuman);
        pairs.add(params);

        String s = HttpUtil.get(url, pairs);

        return JSONObject.parseObject(s);
    }
}
