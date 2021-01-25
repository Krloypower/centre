package code.number;

/**
 * @ClassName 二分法
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/14
 * @Version 1.0
 **/
public class 二分法 {

    public static int find(int[] nums, int target){
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r){
             mid = l + ((r - l) >> 1);

            if (nums[mid] == target){
                return mid;
            }

            if (nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int target = 3;
        System.out.println(find(nums, target));
    }
}
