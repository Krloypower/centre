//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 930 👎 0

package first.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class code_76 {
    public static void main(String[] args) {
        Solution solution = new code_76().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> resource = new HashMap<>();

        public String minWindow(String s, String t) {
            int len = s.length();
            char[] chars = t.toCharArray();
            for (char ch : chars) {
                resource.put(ch, resource.getOrDefault(ch, 0) + 1);
            }
            int left = 0, right = 0, anL = 0, anR = -1, lens = Integer.MAX_VALUE;

            while (right < len) {
                char c = s.charAt(right);
                if (resource.containsKey(c)) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                }
                right++;
                while (left <= right && check()) {
                    if (right - left + 1 < lens) {
                        lens = right - left + 1;
                        anL = left;
                        anR = left + lens;
                    }
                    char c1 = s.charAt(left);
                    if (windows.containsKey(c1)) {
                        windows.put(c1, windows.getOrDefault(c1, 0) - 1);
                    }
                    left++;
                }
            }

            return anR == -1 ? "" : s.substring(anL, anR - 1);
        }

        public boolean check() {
            Iterator<Map.Entry<Character, Integer>> iterator = resource.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> next = iterator.next();
                Character key = next.getKey();
                Integer windowsValue = windows.getOrDefault(key, 0);
                Integer resourceKey = resource.get(key);
                if (windowsValue < resourceKey) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}