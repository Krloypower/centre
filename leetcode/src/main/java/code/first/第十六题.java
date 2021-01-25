package code.first;

import java.util.Arrays;

/**
 * @ClassName 第十七题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/7
 * @Version 1.0
 **/
public class 第十六题 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i< nums.length ;i ++){
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(target - res)){
                    res = sum;
                }

                if (sum > target){
                    r --;
                }else if (sum < target){
                    l ++;
                }else {
                    return res;
                }
            }
        }
        return res;
    }
}
