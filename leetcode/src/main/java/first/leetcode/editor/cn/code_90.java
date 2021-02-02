//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 375 👎 0

package first.leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_90 {
    public static void main(String[] args) {
        Solution solution = new code_90().new Solution();

        int[] nums = {1, 2, 2};
        System.out.println(solution.subsetsWithDup(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] bool;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            int len = nums.length;
            bool = new boolean[len];
            Arrays.sort(nums);
            dfs(nums, 0, len);
            return res;
        }

        // 1 2 2
        private void dfs(int[] nums, int start, int len) {
            res.add(new ArrayList<>(temp));


            for (int i = start; i < len; i++) {
                // 同一层使用，需要上一次的树枝为true
                if (i > 0 && nums[i - 1] == nums[i] && !bool[i - 1]) {
                    continue;
                }
                temp.add(nums[i]);
                bool[i] = true;
                dfs(nums, i + 1, len);
                temp.remove(temp.size() - 1);
                bool[i] = false;
            }


        }

//        private void dfs(int[] nums, int start, int len) {
//            res.add(new ArrayList<>(temp));
//            for (int i = start; i < len; i++) {
//                // 同层索引
//                if (i > start && nums[i - 1] == nums[i]) {
//                    continue;
//                }
//                temp.add(nums[i]);
//                dfs(nums, i + 1, len);
//                temp.remove(temp.size() - 1);
//            }
//
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}