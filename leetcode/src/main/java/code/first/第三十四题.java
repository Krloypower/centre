package code.first;

/**
 * @ClassName 第三十四题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/14
 * @Version 1.0
 **/
public class 第三十四题 {

    public static int[] searchRange(int[] nums, int target) {

        int left = search(nums, target, true);
        int right = search(nums, target, false) - 1;

        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};

    }

    public static int search(int[] nums, int target, boolean lower) {
        int i = 0, j = nums.length - 1, res = nums.length;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                j = mid - 1;
                res = mid;
            } else {
                i = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        int[] ints = searchRange(nums, target);
        System.out.println(ints);
    }
}
