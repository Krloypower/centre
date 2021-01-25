package code.character;

import java.util.Stack;

/**
 * @ClassName 字符串翻转 递归
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/11
 * @Version 1.0
 **/
public class 字符串翻转 {

    public static String reverse(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        return reverse(str.substring(1)) + str.charAt(0);
    }


    public static String reverse1(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (Character temp : chars) {
            stack.push(temp);
        }
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("abcd"));
        System.out.println(reverse1("abcd"));
    }


    public static String reverse2(String str) {
        if (str == null && str.length() <= 1) {
            return str;
        }

        return reverse(str.substring(1)) + str.charAt(0);
    }
}
