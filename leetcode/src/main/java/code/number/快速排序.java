package code.number;

/**
 * @ClassName 快速排序
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/26
 * @Version 1.0
 **/
public class 快速排序 {


    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        sort(nums, 0, nums.length - 1);
        System.out.println(nums);
    }


    private static void sort(int[] nums, int l, int r) {
        if (l < r) {
            int start = quitSort(nums, l, r);
            sort(nums, start + 1, r);
            sort(nums, l, start - 1);
        }

    }


    private static int quitSort(int[] nums, int l, int r) {

        int temp = nums[l];

        while (l < r) {

            while (l < r && nums[r] > temp) {
                r--;
            }
            if (l < r) {
                nums[l] = nums[r];
            }

            while (l < r && nums[l] < temp) {
                l++;
            }
            if (l < r) {
                nums[r] = nums[l];
            }
        }
        nums[l] = temp;
        return l;
    }
}
