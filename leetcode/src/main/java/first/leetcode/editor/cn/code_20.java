//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2330 👎 0

package first.leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class code_20 {
    public static void main(String[] args) {
        Solution solution = new code_20().new Solution();
        System.out.println(solution.isValid("()[]{}"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            char[] array = s.toCharArray();
            Map<Character, Character> temp = new HashMap();
            temp.put('{', '}');
            temp.put('[', ']');
            temp.put('(', ')');
            Deque<Character> deque = new LinkedList<>();
            for (Character x : array) {
                if (x == '{' || x == '(' || x == '[') {
                    deque.push(x);
                } else if (x.equals(temp.get(deque.peek()))) {
                    deque.pop();
                }else {
                    deque.push(x);
                }
            }
            return deque.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}