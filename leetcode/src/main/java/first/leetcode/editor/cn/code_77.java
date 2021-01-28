//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 472 👎 0

package first.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class code_77 {
    public static void main(String[] args) {
        Solution solution = new code_77().new Solution();
        System.out.println(solution.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            dfs(res, temp, 1, n, k);
            return res;
        }

        public void dfs(List<List<Integer>> res, List<Integer> temp, int start, int n, int k) {

            if (temp.size() == k) {
//                System.out.println("递归结束：" + temp);
                res.add(new ArrayList<>(temp));
                return;
            }
            for (int i = start; i <= n; i++) {
//                System.out.println("递归前：" + temp);
                temp.add(i);
                dfs(res, temp, i + 1, n, k);
                temp.remove(temp.size() - 1);
//                System.out.println("递归后：" + temp);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}