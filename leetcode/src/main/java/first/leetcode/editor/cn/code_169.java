//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 876 👎 0

package first.leetcode.editor.cn;

import java.util.Arrays;

public class code_169 {
    public static void main(String[] args) {
        Solution solution = new code_169().new Solution();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(solution.majorityElement(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {

            Arrays.sort(nums);
            int mid = nums.length / 2;
            int temp = 1;
            int flag = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (flag == nums[i]) {
                    temp++;
                } else {
                    flag = nums[i];
                    temp = 1;
                }
                if (temp > mid) {
                    return flag;
                }
            }
            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}