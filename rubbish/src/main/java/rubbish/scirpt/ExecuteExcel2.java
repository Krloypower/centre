package rubbish.scirpt;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.FileWriter;

/**
 * @ClassName ExecuteExcel
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/8/10
 * @Version 1.0
 **/
public class ExecuteExcel2 {

    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("/Users/ouyangkang/Documents/SKU内容更新.xlsx");

        XSSFWorkbook sheets = new XSSFWorkbook(file);
        XSSFSheet sheetAt = sheets.getSheetAt(5);

        int rowsCount = sheetAt.getPhysicalNumberOfRows();

        FileWriter fileWriter = null;
        fileWriter = new FileWriter("/Users/ouyangkang/Documents/result1.txt");




        for (int i = 2; i < rowsCount; i++) {
            String sql = "UPDATE sku_material SET ";
            XSSFRow row = sheetAt.getRow(i);
            if (row != null) {
                String id = row.getCell(0).toString();
                String image = row.getCell(1).toString();
                String logion = row.getCell(2).toString();
                String desc = row.getCell(3).toString();


                if (!StringUtils.isEmpty(logion)) {
                    sql += "logion='" + logion + "',";
                }

                if (!StringUtils.isEmpty(desc)) {
                    sql += "description='" + desc + "',";
                }

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
}
