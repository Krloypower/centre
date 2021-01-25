//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1081 👎 0

package first.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class code_46 {
    public static void main(String[] args) {
        Solution solution = new code_46().new Solution();

        int[] nums = {1, 2, 3};
        System.out.println(solution.permute(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            List<Integer> path = new ArrayList<>();

            boolean[] used = new boolean[len];
            dfs(nums, 0, len, used, path, res);
            return res;
        }

        private void dfs(int[] nums, int depth, int len, boolean[] used, List<Integer> path, List<List<Integer>> res) {
            if (len == depth){
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i< len; i++){
                if (used[i]){
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1, len, used, path, res);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}