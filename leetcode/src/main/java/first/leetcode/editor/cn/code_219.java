//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 
// 👍 244 👎 0

package first.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class code_219 {
    public static void main(String[] args) {
        Solution solution = new code_219().new Solution();
        int[] nums= {99,99};
        System.out.println(solution.containsNearbyDuplicate(nums, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (nums.length <=0){
                return false;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0 ; i < nums.length; i++){
                Integer idx = map.getOrDefault(nums[i], i);
                if (idx != i){
                    int temp = i - idx;
                    if (temp > k){
                        map.put(nums[i], i);
                    }else {
                        return true;
                    }
                }else {
                    map.put(nums[i], i);
                }

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}