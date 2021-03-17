//编写一个程序判断给定的数是否为丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例 1: 
//
// 输入: 6
//输出: true
//解释: 6 = 2 × 3 
//
// 示例 2: 
//
// 输入: 8
//输出: true
//解释: 8 = 2 × 2 × 2
// 
//
// 示例 3: 
//
// 输入: 14
//输出: false 
//解释: 14 不是丑数，因为它包含了另外一个质因数 7。 
//
// 说明： 
//
// 
// 1 是丑数。 
// 输入不会超过 32 位有符号整数的范围: [−231, 231 − 1]。 
// 
// Related Topics 数学 
// 👍 178 👎 0

package first.leetcode.editor.cn;

public class code_263 {
    public static void main(String[] args) {
        Solution solution = new code_263().new Solution();
        solution.isUgly(6);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isUgly(int n) {
            if (n == 0) {
                return false;
            }
            while (n % 2 == 0) {
                n /= 2;
            }

            while (n % 3 == 0) {
                n /= 3;
            }

            while (n % 5 == 0) {
                n /= 5;
            }
            return n == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}