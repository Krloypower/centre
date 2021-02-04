//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
//
// 
//
// 示例： 
//
// 
//输入：[1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 30,000。 
// 所给数据范围 [-10,000，10,000]。 
// 
// Related Topics 数组 
// 👍 148 👎 0

package first.leetcode.editor.cn;

public class code_643 {
    public static void main(String[] args) {
        Solution solution = new code_643().new Solution();
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(solution.findMaxAverage(nums, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {

            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            int max = sum;
            for (int i = k; i < nums.length; i++) {
                sum = sum - nums[i - k] + nums[i];
                max = Math.max(max, sum);
            }

            return max * 1.0 / k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}