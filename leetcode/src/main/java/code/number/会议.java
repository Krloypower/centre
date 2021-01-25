package code.number;

import java.util.Arrays;

/**
 * @ClassName 会议
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/20
 * @Version 1.0
 **/
public class 会议 {

    public static void main(String[] args) {
        int[][] nums = {{1,10},{20,30},{12,15}};
        System.out.println(ishave(nums));
    }

    public static boolean ishave(int[][] nums) {
        Arrays.sort(nums, (v1, v2) -> v1[0] - v2[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i][0] < nums[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
