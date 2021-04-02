//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 319 👎 0

package first.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class code_290 {
    public static void main(String[] args) {
        Solution solution = new code_290().new Solution();
        solution.wordPattern("abba", "dog cat cat dog");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            Map<String, String> map = new HashMap<>();
            Set<String> value = new HashSet<>();
            String[] split = pattern.split("");
            String[] s1 = s.split(" ");
            if (split.length != s1.length) {
                return false;
            }
            for (int i = 0; i < split.length; i++) {
                String s2 = map.get(split[i]);
                if (s2 != null){
                    if (!s2.equals(s1[i])){
                        return false;
                    }else {
                        continue;
                    }
                }

                if (value.contains(s1[i])){
                    return false;
                }else {
                    map.put(split[i], s1[i]);
                    value.add(s1[i]);
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}