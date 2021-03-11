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
        Writer writer = new FileWriter("/Users/ouyangkang/temp/insertTblSaleIncome.sql", false);
        while ((str = reader.readLine()) != null) {
            String[] split = str.split("\t");
            StringJoiner st = new StringJoiner(",");
            st.add(split[1]).add("1").add("'"+split[2]+"'").add(split[3]).add("3");
            String sql = "insert into tbl_sale_income(business_id, business_type, income_time, income_amount ,income_type) values(" + st.toString() + ");";
            writer.append(sql).append("\t\n");
        }
        writer.close();
        fileReader.close();
        reader.close();
    }
}
