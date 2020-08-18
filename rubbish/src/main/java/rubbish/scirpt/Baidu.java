package rubbish.scirpt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Baidu
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-12-09 11:34
 **/
public class Baidu {

    public static void main(String[] args) {
        String regex = "\\(.*?\\(.*?\\).*?\\)|\\[.*?\\（.*?\\）.*?\\]";
        String target = "你们[今晚要来（新书）我的你和]";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(target);
        if (matcher.find()){
            String group = matcher.group();
            target = target.replace(group, "");
            System.out.println(group);
        }
        System.out.println(target);

    }
}
