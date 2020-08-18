package com.kroly.centre.scirpt;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @ClassName TextRead
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/8/10
 * @Version 1.0
 **/
public class TextRead {


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/ouyangkang/Documents/sku.txt"));
        String str;

        String sql = "UPDATE sku_material SET update_time = NOW(), ";

        while ((str = reader.readLine()) != null){
            String[] temp = str.split("\t", -1);
            if (temp.length  > 0){
                String logion = temp[2];
                if (!StringUtils.isEmpty(logion)){
                    sql += "logion="+logion + ",";
                }
                String desc = temp[3];

                if (!StringUtils.isEmpty(desc)){
                    sql += "description="+desc + ",";
                }
                String usage = temp[4];

                if (!StringUtils.isEmpty(usage)){
                    sql += "usage_scenario="+format(usage) + ",";
                }
                String portfolioIds = temp[5];

                if (!StringUtils.isEmpty(portfolioIds)){
                    sql += "portfolio_ids="+format(portfolioIds) + ",";
                }
                String skuIds = temp[6];

                if (!StringUtils.isEmpty(skuIds)){
                    sql += "material_ids="+format(skuIds) + ",";
                }
                String customerReviews = temp[7];

                if (!StringUtils.isEmpty(customerReviews)){
                    sql += "customer_reviews="+customerReviews + ",";
                }

                String id = temp[0];
                if (StringUtils.isEmpty(id)){
                    continue;
                }else {
                    sql += " where id=" + id;
                }
            }
            System.out.println(sql);
        }
    }

    public static String format(String str){
        if (StringUtils.isEmpty(str)){
            return null;
        }
        String[] split = str.split(",");
        StringBuffer result = new StringBuffer();
        for (String string : split){
            result.append(result).append(",");
        }

        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}


