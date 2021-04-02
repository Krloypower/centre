//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1009 👎 0

package first.leetcode.editor.cn;

public class code_283 {
    public static void main(String[] args) {
        Solution solution = new code_283().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            //左指针
            int l = nums.length;
            // 找出指针开始
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    l = i;
                    break;
                }
            }
            //右指针
            int r = l + 1;
            while (r < nums.length) {
                // 交换指针
                if (nums[r] != 0) {
                    int temp = nums[r];
                    nums[r] = nums[l];
                    nums[l] = temp;
                    l++;
                }
                r++;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}