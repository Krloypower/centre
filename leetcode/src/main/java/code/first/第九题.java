package code.first;

/**
 * @ClassName 第九题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/6
 * @Version 1.0
 **/
public class 第九题 {

    public static boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int result = 0;

        while (x > result) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        return x == result || result / 10 == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
