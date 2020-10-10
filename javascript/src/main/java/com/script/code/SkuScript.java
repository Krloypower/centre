package com.script.code;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @ClassName SkuScript
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/8/25
 * @Version 1.0
 **/
public class SkuScript {


    public static void main(String[] args) throws Exception {

        Reader reader = new FileReader("/Users/ouyangkang/temp/id.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String readLine = null;
        Map<Integer, String> skuId = getSkuId();


        Writer writer = new FileWriter("/Users/ouyangkang/temp/result.txt");

        while ((readLine = bufferedReader.readLine()) != null){
            String[] split = readLine.split("\t");
            String sId = split[0];
            Integer id = Integer.valueOf(split[1]);
            String skuIds = skuId.get(id);
            if (!StringUtils.isEmpty(skuIds)){
                List<String> ids = Arrays.stream(skuIds.split(",")).collect(Collectors.toList());
                ids.remove(sId);
                Random random = new Random();
                List<String> result = Lists.newArrayList();
                StringBuffer resultIds = new StringBuffer();


                if (ids.size() <= 4){
                    for (int i = 0; i< ids.size(); i++){
                        resultIds.append(ids.get(i)).append(",");
                    }
                }else {

                    while (result.size() != 4){
                        int nextInt = random.nextInt(ids.size());
                        String idsId = ids.get(nextInt);
                        if (!result.contains(idsId)){
                            result.add(idsId);
                        }
                    }
                    for (int i = 0; i< result.size(); i++){
                        resultIds.append(result.get(i)).append(",");
                    }

                }

                resultIds.deleteCharAt(resultIds.length() - 1);
                String sql = "update sku_material set material_ids='"+resultIds.toString()+ "'" + " where id="+ sId + ";";
                writer.append(sql).append("\t\n");
                System.out.println(sql);

            }

        }
        writer.close();
        bufferedReader.close();
        reader.close();


    }
    public static Map<Integer, String> getSkuId() throws Exception {
        Reader reader = new FileReader("/Users/ouyangkang/temp/sku.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String readLine = null;
        Map<Integer, String> map = Maps.newHashMap();

        while ((readLine = bufferedReader.readLine()) != null){
            String[] split = readLine.split("\t");
            map.put(Integer.valueOf(split[0]), split[1]);
        }
        bufferedReader.close();
        reader.close();
        return map;
    }
}
