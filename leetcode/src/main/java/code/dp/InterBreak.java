package code.dp;

/**
 * @ClassName InterBreak
 * @Description https://leetcode-cn.com/problems/integer-break/ leetcode题目343
 * @Author ouyangkang
 * @Date 2020/7/30
 * @Version 1.0
 **/
public class InterBreak {

    public static int solution(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(11));
    }
}
