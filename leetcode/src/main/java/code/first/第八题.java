package code.first;

/**
 * @ClassName 第八题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/5
 * @Version 1.0
 **/
public class 第八题 {

    public static int myAtoi(String s) {
        int length = s.length();
        if (length <= 0) {
            return 0;
        }

        char[] chars = s.toCharArray();

        int index = 0;
        int sign = 1;

        while (index < length && chars[index] == ' ') {
            index++;
        }

        if (index == length) {
            return 0;
        }
        char fisrtChar = chars[index];
        if (fisrtChar == '-') {
            sign = -1;
            index++;
        } else if (fisrtChar == '+') {
            index++;
        }

        int res = 0;

        while (index < length) {

            char aChar = chars[index];
            if (!Character.isDigit(aChar)) {
                break;
            }

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (aChar - '0') > 7)) {
                return Integer.MAX_VALUE;
            }

            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (aChar - '0') > 8)) {
                return Integer.MIN_VALUE;
            }

            index++;
            res = res * 10 + sign * (aChar - '0');
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483646"));
    }
}
