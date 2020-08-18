package rubbish.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName RegexMatches
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-08-02 17:10
 **/
public class RegexMatches {
    public static void main( String args[] ){

        // 按指定模式在字符串查找
        String line = "123ra9040 123123aj234 adf12322ad 222jsk22";
        String pattern = "(\\d+)([a-z]+)(\\d+)";
//        String pattern1 = "([\\u4E00-\\u9FA5]+|\\w+)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        int i = 0;
        while (m.find( )) {
            // 拿到上面匹配到的数据
            System.out.println("----i="+i);
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
            i++;
            System.out.println("|||||||");
        }
    }


}
