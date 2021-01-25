package code.first;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName code.first.第二十二题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/11
 * @Version 1.0
 **/
public class 第二十二题 {

    static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {

        dfs("", 0, 0, n);
        return res;
    }

    public static void dfs(String s, int left, int right, int n) {

        if (left > n || right > n){
            return;
        }
        if (left < right) {
            return;
        }

        if (left == n && right == n) {
            res.add(s);
        }



        dfs(s + "(", left + 1, right, n);

        dfs(s + ")", left, right + 1, n);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}

