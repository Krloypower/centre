package code.first;

/**
 * @ClassName 第二十九题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/12
 * @Version 1.0
 **/
public class 第二十九题 {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean k = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        int de = -Math.abs(dividend);
        int di = -Math.abs(divisor);

        int res = 0;

        while (de <= di) {

            int temp = di;
            int i = 1;

            while (de - temp <= temp) {
                temp <<= 1;
                i <<= 1;
            }

            de -= temp;
            res += i;
        }

        return k ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
    }
}
