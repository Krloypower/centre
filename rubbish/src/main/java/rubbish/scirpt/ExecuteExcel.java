package rubbish.scirpt;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ExecuteExcel
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/8/10
 * @Version 1.0
 **/
public class ExecuteExcel {

    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("/Users/ouyangkang/Documents/SKU内容更新.xlsx");

        XSSFWorkbook sheets = new XSSFWorkbook(file);
        XSSFSheet sheetAt = sheets.getSheetAt(0);

        int rowsCount = sheetAt.getPhysicalNumberOfRows();

        FileWriter fileWriter = null;
        fileWriter = new FileWriter("/Users/ouyangkang/Documents/result.txt");


        Map<String, String> urlMap = geturl(sheets);

        StringBuffer sb = new StringBuffer();


        for (int i = 2; i < rowsCount; i++) {
            String sql = "UPDATE sku_material SET ";
            XSSFRow row = sheetAt.getRow(i);
            if (row != null) {
                String id = row.getCell(0).toString();
                if (id.contains("delete") || id.contains("新增")){
                    sb.append(id.replace("delete","").replace("-","").trim()).append(",");
                    continue;
                }
                String logion = row.getCell(2).toString();
                String desc = row.getCell(3).toString();
                String usage = row.getCell(4).toString();
                String portfolioIds = row.getCell(5).toString();
                String skuIds = row.getCell(6).toString();
                String customerReviews = row.getCell(7).toString();
                String customerReviews1 = row.getCell(8).toString();
                String customerReviews2 = row.getCell(9).toString();

                if (!StringUtils.isEmpty(logion)) {
                    sql += "logion='" + logion + "',";
                }

                if (!StringUtils.isEmpty(desc)) {
                    sql += "description='" + desc + "',";
                }

                if (!StringUtils.isEmpty(usage)) {
                    sql += "usage_scenario='" + format(usage) + "',";
                }

                if (!StringUtils.isEmpty(portfolioIds)) {
                    sql += "portfolio_ids='" + format(portfolioIds) + "',";
                }

                if (!StringUtils.isEmpty(skuIds)) {
                    sql += "material_ids='" + format(skuIds) + "',";
                }

                sql += "customer_reviews='" + userrevew(urlMap, customerReviews,customerReviews1,customerReviews2) + "',";
                sql += "update_time = NOW() ";

                if (StringUtils.isEmpty(id)) {
                    continue;
                } else {
                    sql += " where id=" + Double.valueOf(id).longValue() + ";";
                }

            }
            System.out.println(sql);
            fileWriter.write(sql + "\r\n");
        }

        System.out.println(sb.toString());

        fileWriter.flush();
        fileWriter.close();
    }

    public static void write(String sql) {

    }

    public static String format(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        StringBuffer result = new StringBuffer();
        for (String string : split) {
            result.append(string.trim()).append(",");
        }

        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static Map<String, String> geturl(XSSFWorkbook sheets) throws Exception {
        Map<String, String> result = new HashMap<>();
        XSSFSheet sheetAt = sheets.getSheetAt(5);
        int rowsCount = sheetAt.getPhysicalNumberOfRows();

        for (int i = 1; i < 43; i++) {
            XSSFRow row = sheetAt.getRow(i);
            if (row != null) {
                String id = row.getCell(0).toString();
                String image = null;
                try {
                    image = row.getCell(3).toString();
                } catch (Exception e) {
                    System.out.println(id);
                    e.printStackTrace();
                }
                result.put(Long.valueOf(Double.valueOf(id).longValue()).toString(), image);
            }
        }

        return result;
    }

    public static String userrevew(Map<String, String> maps, String ...r1){
        JSONArray jsonArray = new JSONArray();
        for (String rw : r1){
            if (!StringUtils.isEmpty(rw)){
                if (rw.equals("0") || rw.equals("0.0")){
                    continue;
                }
                JSONObject jsonObject = new JSONObject();
                String[] split = rw.split(",");
                String key = split[0];
                String url = maps.get(key);
                String desc = split[1];
                jsonObject.put("url",url);
                jsonObject.put("desc",desc);
                jsonArray.add(jsonObject);
            }
        }
        return jsonArray.toJSONString();
    }
}
