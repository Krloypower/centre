package rubbish.scirpt;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.StringJoiner;

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
        Writer writer = new FileWriter("/Users/ouyangkang/temp/updateSale.sql", false);
        while ((str = reader.readLine()) != null) {
            String[] split = str.split("\t");
            String sql = "UPDATE tbl_sale_opportunity SET stage_id="+split[0]+"  where id="+split[1] + ";";
            writer.append(sql).append("\t\n");
        }
        writer.close();
        fileReader.close();
        reader.close();
    }
}
