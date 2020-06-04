package com.kroly.centre.leetcode;

/**
 * @ClassName LongestCommonPrefix
 * @Description 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 “”。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [“flower”,“flow”,“flight”]
 * 输出: “fl”
 * <p>
 * 示例 2:
 * <p>
 * 输入: [“dog”,“racecar”,“car”]
 * 输出: “”
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * @Author kang.ouyang
 * @Date 2020-06-04 11:04
 **/
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
       if (strs.length ==0){
           return "";
       }
       String result = strs[0];

       for (int i = 0; i < strs.length ;i ++){
           while (strs[i].indexOf(result) != 0){
               result = result.substring(0, result.length() - 1);
               if (result.length() == 0){
                   return "";
               }
           }
       }
       return result;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
