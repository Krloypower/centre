package code.first;

/**
 * @ClassName 第七题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/5
 * @Version 1.0
 **/
public class 第七题 {

    public static int reverse(int x) {

        long ans = 0L;

        while (x != 0) {

            ans = ans * 10 + x % 10;
            x = x / 10;
        }

        return ans == (int) ans ? (int) ans : 0;
    }
}
