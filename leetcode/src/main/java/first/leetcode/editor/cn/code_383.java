//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。 
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。) 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设两个字符串均只含有小写字母。 
// 
// Related Topics 字符串 
// 👍 145 👎 0

package first.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_383 {
    public static void main(String[] args) {
        Solution solution = new code_383().new Solution();
        solution.canConstruct("aa","aab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()){
                return false;
            }
            int[] temp = new int[26];
            int res = ransomNote.length();

            for (int i = 0; i < ransomNote.length(); i++){
                temp[ransomNote.charAt(i) - 97]++;
            }

            for (int i = 0 ; i< magazine.length() && res > 0; i++){
                if (temp[magazine.charAt(i) - 97] != 0){
                    temp[magazine.charAt(i) - 97]--;
                    res--;
                }
            }
            return res == 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}