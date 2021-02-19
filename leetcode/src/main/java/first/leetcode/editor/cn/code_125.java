//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 330 👎 0

package first.leetcode.editor.cn;

public class code_125 {
    public static void main(String[] args) {
        Solution solution = new code_125().new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            StringBuffer sb = new StringBuffer();
            for (Character ch : s.toCharArray()){
                if (Character.isLetterOrDigit(ch)){
                    sb.append(ch);
                }
            }
            int left = 0, right = sb.length() - 1;
            while (left < right){
                if (Character.toLowerCase(sb.charAt(left)) != Character.toLowerCase(sb.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}