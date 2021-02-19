//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 261 👎 0

package first.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class code_119 {
    public static void main(String[] args) {
        Solution solution = new code_119().new Solution();
        System.out.println(solution.getRow(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < rowIndex + 1; i++) {
                if (i < 2) {
                    res.add(1);
                } else {
                    res = new ArrayList<>(dfs(res));
                }
            }
            return res;
        }

        private List<Integer> dfs(List<Integer> nums) {
            List<Integer> res = new ArrayList<>();
            for (int i = 1; i < nums.size(); i++) {
                res.add(nums.get(i) + nums.get(i - 1));
            }
            res.add(0, 1);
            res.add(1);
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}