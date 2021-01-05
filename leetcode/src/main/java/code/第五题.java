package code;

import java.util.Arrays;

/**
 * @ClassName 第五题
 * @Description 最长回文子串， 暴力，动态规划，中心扩散。
 * @Author ouyangkang
 * @Date 2021/1/5
 * @Version 1.0
 **/
public class 第五题 {

    public static String baoli(String s) {
        return null;
    }

    /**
     * 动态规划，填表格。自底向上
     **/
    public static String dp(String s) {

        int len = s.length();

        if (len <= 0) {
            return null;
        }

        Boolean[][] dp = new Boolean[len][len];

        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], false);
        }

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int max = 1;
        int start = 0;
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(dp(s));
    }
}
