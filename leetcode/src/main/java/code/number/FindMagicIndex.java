package code.number;

/**
 * @ClassName FindMagicIndex
 * @Description https://leetcode-cn.com/problems/magic-index-lcci/
 * @Author ouyangkang
 * @Date 2020/7/31
 * @Version 1.0
 **/
public class FindMagicIndex {

    public static int solution(int[] nums){

        int flag = 0;
        while (flag < nums.length) {

            if (nums[flag] == flag) {
                return flag;
            } else if (nums[flag] > flag) {  //重点 , 过滤掉不需要比较的元素
                flag = nums[flag];
            }else{
                flag++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,1,1,1,10};
        System.out.println(solution(nums));
    }
}
