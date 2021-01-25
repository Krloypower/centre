package code.first;

/**
 * @ClassName 第三十一题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/13
 * @Version 1.0
 **/
public class 第三十一题 {

    public static void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j > 0 && nums[i] >= nums[j]) {
                j--;
            }
            if (j > 0) {
                swap(nums, i, j);
            }
        }
        reverse(nums, i + 1);

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int i) {
        int left = i, right = nums.length - 1;

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
