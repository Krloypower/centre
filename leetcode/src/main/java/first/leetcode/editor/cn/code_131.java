//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 502 👎 0

package first.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class code_131 {
    public static void main(String[] args) {
        Solution solution = new code_131().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] dp;
        List<List<String>> res;
        Deque<String> path;

        public List<List<String>> partition(String s) {
            if (s == null){
                return null;
            }
            res = new ArrayList<>();
            path = new ArrayDeque<>();
            int len = s.length();
            dp = new boolean[len][len];

            for (int i = 0 ; i < len ; i++){
                dp[i][i] = true;
            }

            for (int j = 1; j < len; j++){
                for (int i = j - 1; i >=0; i--){
                    if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1])){
                        dp[i][j] = true;
                    }
                }
            }

            dfs(s, 0 ,len);
            return res;
        }

        private void dfs(String s, int index, int len) {
            if (index == len){
                res.add(new ArrayList<>(path));
            }
            for (int i = index; i < len ; i++){
                if (dp[index][i]){
                    path.add(s.substring(index, i + 1));
                    dfs(s, i + 1, len);
                    path.removeLast();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}