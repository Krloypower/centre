//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ： 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A
//" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "
//6" 和 "06" 不同。 
//
// 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。由于没有字符，因此没有有效的方法对此进行
//解码，因为所有数字都需要映射。
// 
//
// 示例 4： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 不能映射到 "F" ，因为字符串开头的 0 无法指向一个有效的字符。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 611 👎 0

package first.leetcode.editor.cn;

public class code_91 {
    public static void main(String[] args) {
        Solution solution = new code_91().new Solution();
        System.out.println(solution.numDecodings("301"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            int len = s.length();
            int[] dp = new int[len];
            char i1 = s.charAt(0);
            if (i1 == '0') {
                return 0;
            } else {
                dp[0] = 1;
            }
            if (len >= 2) {
                char c = s.charAt(1);
                int i = c - '0';
                int i2 = i1 - '0';
                int i3 = i2 * 10 + i;
                if (i == 0) {
                    if (i3 > 26) {
                        return 0;
                    }
                    dp[1] = 1;
                } else if (i3 > 26) {
                    dp[1] = 1;
                } else {
                    dp[1] = 2;
                }

                for (int j = 2; j < s.length(); j++) {
                    int i5 = s.charAt(j) - '0';
                    int i4 = s.charAt(j - 1) - '0';
                    int n = i4 * 10 + i5;
                    if (i4 == 0 && i5 == 0) {
                        return 0;
                    }
                    if (i4 == 0) {
                        dp[j] = dp[j - 1];
                    } else if (i5 == 0) {
                        if (n > 26) {
                            return 0;
                        } else {
                            dp[j] = dp[j - 2];
                        }
                    } else if (n > 26) {
                        dp[j] = dp[j - 1];
                    } else {
                        dp[j] = dp[j - 1] + dp[j - 2];
                    }
                }
            }

            return dp[len - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}