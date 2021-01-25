package rubbish.scirpt;

import org.springframework.util.StringUtils;

import java.io.*;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/22
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) throws Exception {
        String path = "/Users/ouyangkang/temp/1.txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);
        String str;
        reader.readLine();

        Writer writer = new FileWriter("/Users/ouyangkang/temp/updateSaleStageEndTime.sql",false);
        while ((str = reader.readLine()) != null){
            String[] split = str.split("\t");
            if (split.length ==4 && !StringUtils.isEmpty(split[3].trim())){
                String sql = "UPDATE tbl_sale_opportunity_stage AS a \n" +
                        "INNER JOIN ( SELECT end_stage_id FROM tbl_sale_opportunity_stage WHERE opportunity_id = "+split[0]+" ) AS b \n" +
                        "SET start_time = '"+split[3]+"' \n" +
                        "WHERE\n" +
                        "\ta.id = b.end_stage_id;";
                writer.append(sql).append("\t\n");
            }else {
                if (split.length >0){
                    System.out.println(split[0]);
                }
            }
        }
        writer.close();
        fileReader.close();
        reader.close();
    }
}
