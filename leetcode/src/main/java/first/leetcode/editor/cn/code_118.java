//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 453 👎 0

package first.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class code_118 {
    public static void main(String[] args) {
        Solution solution = new code_118().new Solution();
        System.out.println(solution.generate(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            if (numRows == 0){
                return res;
            }
            res.add(Arrays.asList(1));
            if (numRows == 1){
                return res;
            }
            List<Integer> temp = Arrays.asList(1, 1);
            res.add(temp);

            for (int i = 2; i < numRows; i++) {
                List<Integer> dfs = dfs(temp);
                res.add(dfs);
                temp = new ArrayList<>(dfs);
            }
            return res;
        }

        public List<Integer> dfs(List<Integer> nums) {
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