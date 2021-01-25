package code.first;

/**
 * @ClassName 第三十三题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/14
 * @Version 1.0
 **/
public class 第三十三题 {

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r) {
            mid = l + ((r- l) >> 1);

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[l]) {
                if (nums[mid] > target && target >= nums[l]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,3};
        int target = 3;
        System.out.println(search(nums, target));
    }
}
