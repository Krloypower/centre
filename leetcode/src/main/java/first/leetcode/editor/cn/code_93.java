//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
// 和 "192.168@1.1" 是 无效的 IP 地址。 
//
// 
//
// 示例 1： 
//
// 输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 494 👎 0

package first.leetcode.editor.cn;

import java.util.*;

public class code_93 {
    public static void main(String[] args) {
        Solution solution = new code_93().new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();

        public List<String> restoreIpAddresses(String s) {
            int len = s.length();
            if (len < 4 || len > 12) {
                return res;
            }
            dfs(0, 4, len, s);
            return res;
        }

        private void dfs(int start, int residue, int len, String s) {

            if (start == len) {
                if (residue == 0) {
                    res.add(String.join(".", path));
                }
                return;
            }

            for (int i = start; i < start + 3; i++) {
                if (i >= len) {
                    break;
                }

                if (residue * 3 < len - i) {
                    continue;
                }
                if (judgeIp(s, start, i)) {
                    path.addLast(s.substring(start, i + 1));
                    dfs(i + 1, residue - 1, len, s);
                    path.removeLast();
                }
            }

        }

        private boolean judgeIp(String s, int start, int end) {
            int len = end - start + 1;
            if (len > 1 && s.charAt(start) == '0') {
                return false;
            }

            int add = 0;

            while (start <= end) {
                add = add * 10 + (s.charAt(start) - '0');
                start++;
            }
            return add >= 0 && add <= 255;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}