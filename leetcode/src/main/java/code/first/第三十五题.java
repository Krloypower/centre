package code.first;

/**
 * @ClassName 第三十五题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/15
 * @Version 1.0
 **/
public class 第三十五题 {

    public static int searchInsert(int[] nums, int target) {

        int i = 0, j = nums.length - 1, res = -1;

        while (i <= j) {
            int mid = (i + j) >> 1;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
            res = mid;
            if (nums[mid] < target) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }
}
