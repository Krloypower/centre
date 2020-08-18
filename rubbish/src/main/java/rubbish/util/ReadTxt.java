package rubbish.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @ClassName ReadTxt
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-31 19:42
 **/
@Component
public class ReadTxt {


    public void execute() throws Exception{
        String path = "/Users/xmly/Desktop/xima.txt";

        FileReader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);
        String line;
        String regex = "((\\w*)([\\u4E00-\\u9FA5]+)(\\w*)|\\w+)";
        Pattern pattern = Pattern.compile(regex);

        File file = new File("/Users/xmly/Desktop/result.txt");
        file.createNewFile();

        FileWriter writer = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(writer);

        while ((line=br.readLine() )!=null){
            if (StringUtils.isEmpty(line)){
                continue;
            }
            Matcher matcher = pattern.matcher(line);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()){
                sb.append(matcher.group() + ",");
            }
            String result = sb.toString();
            out.write(result + "\r\n");
        }
        out.flush();

    }
}
