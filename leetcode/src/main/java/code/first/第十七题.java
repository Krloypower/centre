package code.first;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 第十七题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/8
 * @Version 1.0
 **/
public class 第十七题 {

    public static List<String> letterCombinations(String digits) {
        if (digits.length() <= 0){
            return res;
        }

        recursion(digits, new StringBuffer(), 0);

        return res;
    }

    static List<String> res = new ArrayList<>();
    static String[] str = {"", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public static void recursion(String digits, StringBuffer sb, int index) {

        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        char charAt = digits.charAt(index);
        int j = charAt - '0';
        String temp = str[j];
        for (int k = 0; k < temp.length(); k++) {
            sb.append(temp.charAt(k));
            recursion(digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
