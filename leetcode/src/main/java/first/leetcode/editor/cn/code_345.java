//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 149 👎 0

package first.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class code_345 {
    public static void main(String[] args) {
        Solution solution = new code_345().new Solution();
        System.out.println(solution.change("leetcode", 0, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Character> set;

        public Solution() {
            set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
        }

        public String reverseVowels(String s) {
            if (s.length() < 1) {
                return s;
            }
            int h = 0, t = s.length() - 1;

            while (t > h) {
                char head = String.valueOf(s.charAt(h)).toLowerCase().charAt(0);
                while (!set.contains(head) && t > h) {
                    h++;
                    head = String.valueOf(s.charAt(h)).toLowerCase().charAt(0);

                }

                char tail = String.valueOf(s.charAt(t)).toLowerCase().charAt(0);

                while (!set.contains(tail) && t > h) {
                    t--;
                    tail = String.valueOf(s.charAt(t)).toLowerCase().charAt(0);
                }
                if (t > h) {
                    s = change(s, h, t);
                    h++;
                    t--;
                }

            }
            return s;
        }

        public String change(String s, int h, int t) {
            char head = s.charAt(h);
            char tail = s.charAt(t);
            return s.substring(0, h) + tail + s.substring(h + 1, t) + head + s.substring(t + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}