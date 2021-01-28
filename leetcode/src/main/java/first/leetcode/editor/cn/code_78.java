//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 965 👎 0

package first.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class code_78 {
    public static void main(String[] args) {
        Solution solution = new code_78().new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(solution.subsets(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(0, nums);
            return ans;
        }

        public void dfs(int cur, int[] nums) {
            ans.add(new ArrayList<>(tmp));
            for (int j = cur; j < nums.length; j++) {
                tmp.add(nums[j]);
                dfs(j + 1, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}