package code.first;

/**
 * @ClassName code.first.第二十七题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/12
 * @Version 1.0
 **/
public class 第二十七题 {

    public int removeElement(int[] nums, int val) {

        int start = 0;

        for (int num : nums){
            if (num != val){
                nums[start++] = num;
            }
        }
        return start;
    }
}
