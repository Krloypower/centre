//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 561 👎 0

package first.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_47 {
    public static void main(String[] args) {
        Solution solution = new code_47().new Solution();
        int[] nums = {1, 1, 2};
        System.out.println(solution.permuteUnique(nums));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            if (len == 0) {
                return res;
            }
            boolean[] used = new boolean[len];
            List<Integer> path = new ArrayList<>();
            Arrays.sort(nums);
            dfs(nums, 0, len, used, res, path);
            return res;
        }

        private void dfs(int[] nums, int depth, int len, boolean[] used, List<List<Integer>> res, List<Integer> path) {
            if (depth == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                if (used[i]) {
                    continue;
                }

                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1, len, used, res, path);
                path.remove(path.size() - 1);
                used[i] = false;
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}