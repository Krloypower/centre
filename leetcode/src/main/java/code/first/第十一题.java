package code.first;

/**
 * @ClassName 第十一题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/6
 * @Version 1.0
 **/
public class 第十一题 {

    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;

        while (i < j){
            if (height[i] < height[j]){
                res = Math.max(res, height[i] * ( j - i));
                i++;
            }else {
                res = Math.max(res, height[j] * ( j - i));
                j--;
            }
        }
        return res;
    }
}
