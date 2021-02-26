//给定一个整数数组，判断是否存在重复元素。 
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 365 👎 0

package first.leetcode.editor.cn;

import java.util.Arrays;

public class code_217 {
    public static void main(String[] args) {
        Solution solution = new code_217().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            if (nums.length <=0){
                return false;
            }
            Arrays.sort(nums);

            int temp = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] == nums[i]) {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}