//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1115 👎 0

package first.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class code_39 {
    public static void main(String[] args) {
        Solution solution = new code_39().new Solution();
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(solution.combinationSum(candidates, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int length = candidates.length;
            List<List<Integer>> res = new ArrayList<>();
            if (length <= 0) {
                return res;
            }

            List<Integer> path = new ArrayList<>();

            dfs(candidates, 0, length, target, res, path);
            return res;
        }

        public void dfs(int[] candidates, int start, int end, int target, List<List<Integer>> res, List<Integer> path) {

            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            if (start > end || target < 0) {
                return;
            }

            for (int i = start; i < end; i++) {
                System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
                path.add(candidates[i]);
                dfs(candidates, i, end, target - candidates[i], res, path);
                path.remove(path.size() - 1);
                System.out.println("递归之后 => " + path);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}