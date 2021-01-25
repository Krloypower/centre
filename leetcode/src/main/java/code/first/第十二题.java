package code.first;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 第十二题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/6
 * @Version 1.0
 **/
public class 第十二题 {


    public static String intToRoman(int num) {

        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < nums.length && num > 0; i++) {

            while (num >= nums[i]) {
                num -= nums[i];
                res.append(symbols[i]);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }
}
