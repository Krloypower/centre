//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学 
// 👍 314 👎 0

package first.leetcode.editor.cn;

public class code_168 {
    public static void main(String[] args) {

        Solution solution = new code_168().new Solution();
        System.out.println(solution.convertToTitle(701));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int n) {
            StringBuffer sb = new StringBuffer();
            while (n > 0) {
                int t = n % 26;
                if(t == 0){
                    t = 26;
                    n -= 1;
                }
                sb.append((char) ('A' + t - 1));
                n /= 26;
            }
            return sb.reverse().toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}