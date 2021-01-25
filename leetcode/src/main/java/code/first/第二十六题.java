package code.first;

/**
 * @ClassName 第二十六题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/12
 * @Version 1.0
 **/
public class 第二十六题 {

    public static int removeDuplicates(int[] nums) {

        int l = 0, r = 1;

        while (r < nums.length) {

            if (nums[l] == nums[r]) {
                r++;
            } else {
                if (r - l > 1) {
                    nums[l + 1] = nums[r];
                }
                l++;
                r++;
            }
        }
        return l + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3};
        System.out.println(removeDuplicates(nums));
    }
}
