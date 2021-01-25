//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 473 👎 0

package first.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_40 {
    public static void main(String[] args) {
        Solution solution = new code_40().new Solution();
        int[] c = {1, 2, 2, 2, 5};
        int target = 5;
        System.out.println(solution.combinationSum2(c, target));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            int length = candidates.length;
            List<List<Integer>> res = new ArrayList<>();
            if (length <= 0) {
                return res;
            }
            Arrays.sort(candidates);
            List<Integer> path = new ArrayList<>();
            dfs(0, length, target, candidates, res, path);
            return res;
        }

        public void dfs(int start, int end, int target, int[] candidates, List<List<Integer>> res, List<Integer> path) {
            if (start > end) {
                return;
            }
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i < end; i++) {
                if (target - candidates[i] < 0) {
                    break;
                }
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.add(candidates[i]);
                dfs(i + 1, end, target - candidates[i], candidates, res, path);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}