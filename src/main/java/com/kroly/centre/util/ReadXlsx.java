package com.kroly.centre.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ReadXlsx
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-31 11:03
 **/
@Component
public class ReadXlsx {
    private final String path = "/Users/xmly/Desktop/喜马拉雅doc/7月/音乐槽位映射.xlsx";

    public void execute() throws Exception{
        InputStream inputStream = new FileInputStream(path);
        // 将刘读取成对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
        List<List<JSONObject>> excel = new ArrayList<>();
        readExcel(xssfWorkbook,excel);
        if (excel.size() == 0) return;
        writeExcel(excel);



    }

    // 读取 excel
    public void readExcel(XSSFWorkbook xssfWorkbook,List<List<JSONObject>> excel) throws Exception{
        if (xssfWorkbook == null){
            return;
        }
        for (Sheet sheet : xssfWorkbook){
            List<JSONObject> sheetJson = new ArrayList<>();
            if (sheet == null){
                continue;
            }
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum();rowNum++){
                JSONObject json = new JSONObject();
                Row row = sheet.getRow(rowNum);
                int minColix = row.getFirstCellNum();
                int maxColix = row.getLastCellNum();

                for (Integer colix = minColix;colix < maxColix;colix++){
                    Cell cell = row.getCell(colix);
                    if(cell == null){
                        continue;
                    }
                    String title = "";
                    if (colix == 0){
                        int temp = Double.valueOf(cell.toString()).intValue();
                        title = Integer.valueOf(temp).toString();
                    }else {
                        title= cell.toString();
                    }

                    json.put(colix.toString(),title);

                    JSONObject result = null;
                    Cell cell1 = row.getCell(colix + 1);
                    if (cell1 != null){
                        if (title.equals("song") || title.equals("mood")
                                || title.equals("good_song")
                                || title.equals("video_name")
                                || title.equals("substyle")
                                || title.equals("genre")
                                || title.equals("group")){
                            result = sendGet("song",cell1.toString());
                        }else if (title.equals("artist")){
                            result = sendGet("artist",cell1.toString());
                            if (result != null && result.size() == 0){
                                result = sendGet("keyword",cell1.toString());
                                if (result != null && result.size() == 0){
                                    result = sendGet("song",cell1.toString());
                                }
                            }
                        }else if (title.equals("keyword")){
                            result = sendGet("keyword",cell1.toString());
                        }
                        if (result != null && result.size() > 0){
                            json.putAll(result);
                        }
                    }
                }
                sheetJson.add(json);
            }
            // 读取到内存中
            excel.add(sheetJson);
        }
    }

    public void writeExcel(List<List<JSONObject>> excel) throws Exception{
//        File file = new File("/Users/xmly/Desktop/音乐槽位映射.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();

        for (int i = 0; i < excel.size(); i++){
            XSSFSheet sheet = workbook.createSheet();
            XSSFRow first = sheet.createRow(0);
            first.createCell(0).setCellValue("序号");
            first.createCell(1).setCellValue("类型");
            first.createCell(2).setCellValue("值");
            first.createCell(3).setCellValue("albumId");
            first.createCell(4).setCellValue("albumTitle");
            first.createCell(5).setCellValue("trackId");
            first.createCell(6).setCellValue("trackTitle");

            Row row;
            List<JSONObject> list = excel.get(i);
            for (int j = 1; j <= list.size(); j++){
                row = sheet.createRow(j);
                JSONObject jsonObject = list.get(j-1);
                if (jsonObject != null && jsonObject.size() > 0){
                    row.createCell(0).setCellValue(jsonObject.getString("0"));
                    row.createCell(1).setCellValue(jsonObject.getString("1"));
                    row.createCell(2).setCellValue(jsonObject.getString("2"));

                    row.createCell(3).setCellValue(jsonObject.getString("albumId"));
                    row.createCell(4).setCellValue(jsonObject.getString("albumTitle"));
                    row.createCell(5).setCellValue(jsonObject.getString("trackId"));
                    row.createCell(6).setCellValue(jsonObject.getString("trackTitle"));

                }
            }

        }
        FileOutputStream fos = new FileOutputStream("/Users/xmly/Desktop/音乐槽位映射.xlsx");
        workbook.write(fos);
        fos.close();
        System.out.println("写入成功");
    }

    public JSONObject sendGet(String keyWord, String title) throws Exception{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://xyapi.ximalaya.com/child/album/smart_search?";
        String params = "";
        if ("song".equals(keyWord)){
             params = URLEncoder.encode("offset=20&limit=10&app_key=53ba3200998d1cd3f4952fbb58ed50ae&nonce=53ba3200998d1cd3f4952fbb58ed50ae&timestamp=123456&device_id=abc&sig=07bd0b0b44ac1d95f16306fcedefae9c&track_title="+title+"&metadatas=音乐","UTF-8");
        }else if ("artist".equals(keyWord)){
            params = URLEncoder.encode("offset=20&limit=10&app_key=53ba3200998d1cd3f4952fbb58ed50ae&nonce=53ba3200998d1cd3f4952fbb58ed50ae&timestamp=123456&device_id=abc&sig=07bd0b0b44ac1d95f16306fcedefae9c&artist="+title+"&metadatas=音乐");
        }else {
            params = URLEncoder.encode("offset=20&limit=10&app_key=53ba3200998d1cd3f4952fbb58ed50ae&nonce=53ba3200998d1cd3f4952fbb58ed50ae&timestamp=123456&device_id=abc&sig=07bd0b0b44ac1d95f16306fcedefae9c&album_title="+title+"&metadatas=音乐");
        }
        url = url+params;
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response == null) return null;
        JSONObject result = new JSONObject();

        HttpEntity entity = response.getEntity();
        if (entity != null){
            try {
                String entityStr = EntityUtils.toString(entity);

                JSONObject jsonObject = JSON.parseObject(entityStr);
                JSONArray jsonArray = jsonObject.getJSONArray("search_result_tracks");
                if (jsonArray != null && jsonArray.size() > 0 ){
                    JSONObject resultTracks = jsonArray.getJSONObject(0);
                    if (resultTracks != null){
                        JSONObject album = resultTracks.getJSONObject("subordinated_album");
                        if (album != null){
                            result.put("albumId", album.getString("id"));
                            result.put("albumTitle", album.getString("album_title"));
                        }
                        result.put("trackId",resultTracks.getString("id"));
                        result.put("trackTitle",resultTracks.getString("track_title"));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }



}
