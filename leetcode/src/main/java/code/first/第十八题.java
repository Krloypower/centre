package code.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName code.first.第十八题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/8
 * @Version 1.0
 **/
public class 第十八题 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i <= len - 4; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j <=len -3; j++){
                int l = j + 1;
                int r = len - 1;
                if (j > i+1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                while (l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target){
                        r --;
                    }else if (sum < target){
                        l++;
                    }else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]){
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]){
                            r --;
                        }
                        l++;
                        r--;

                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
}
