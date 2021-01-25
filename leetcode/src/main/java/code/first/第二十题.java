package code.first;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName 第二十题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/8
 * @Version 1.0
 **/
public class 第二十题 {

    public static boolean isValid(String s) {

        int length = s.length();
        if (length <= 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char charAt = s.charAt(i);
            if (charAt == '(') {
                stack.push(')');
            } else if (charAt == '{') {
                stack.push('}');
            }else if (charAt =='['){
                stack.push(']');
            }else if (stack.isEmpty() || charAt != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        System.out.println(isValid(""));
    }
}
