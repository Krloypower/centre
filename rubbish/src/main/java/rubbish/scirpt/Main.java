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

        Writer writer = new FileWriter("/Users/ouyangkang/temp/updateVProjectCreateTime.sql", false);
        while ((str = reader.readLine()) != null) {
            String[] split = str.split("\t");
            if (split.length == 6) {
                String sql = "UPDATE tbl_virtual_project set create_time='" + split[4] + "' WHERE id=" + split[5] + ";";
                writer.append(sql).append("\t\n");
            } else {
                if (split.length > 0) {
                    System.out.println(split[0]);
                }
            }
        }
        writer.close();
        fileReader.close();
        reader.close();
    }
}
