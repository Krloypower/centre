package code.character;

/**
 * @ClassName CheckInclusion
 * @Description 一、题目描述
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * 来源：力扣（LeetCode）链接：https://leetcode-cn.com/problems/permutation-in-string
 * <p>
 * 二、题解 
 *     其实我们并不需要生成字符串的所有排列，只需要将第一个字符串的各个字符及其个数用map存起来，然后在第二个字符串中取与s1等长的字符串，也用map存起来，然后对比两个map中相同的字符，它的个数是否相同，如果相同的话，就能说明第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 *     然后就是应用滑动窗口的思想，这里只要就是用到将窗口平移的手段，因为我们是要取与s1等长的字符串嘛，详细看下面代码
 */

public class CheckInclusion {

    public static boolean solution(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            boolean same = isSame(s1, s2.substring(i, i + s1.length()));
            if (same){
                return true;
            }
        }
        return false;
    }

    public static boolean isSame(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            str2 = str2.replaceFirst(String.valueOf(str1.charAt(i)), "");
        }
        if ("".equals(str2)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution("ab","eidbaooo"));
    }
}
