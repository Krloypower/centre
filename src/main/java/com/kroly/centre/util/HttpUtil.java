package com.kroly.centre.util;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName HttpUtil
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-08-28 16:42
 **/
public class HttpUtil {
    // 发起get 请求
    public static String get(String path, List<NameValuePair> param) throws Exception{
        URIBuilder builder = new URIBuilder(path);
        builder.setParameters(param);
        HttpGet get = new HttpGet(builder.build());
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = httpClient.execute(get);
        return EntityUtils.toString(response.getEntity());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(toPinyin("打开空调"));
    }

    public static String toPinyin(String hanyu) throws Exception {
        char[] split = hanyu.toCharArray();
        StringBuffer result = new StringBuffer();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char str : split){
            String[] array = PinyinHelper.toHanyuPinyinStringArray(str, format);
            if (array != null && array.length > 0)
                result.append(array[0]).append(" ");
        }

        return result.toString().trim();
    }


}
