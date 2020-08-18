package code.general;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-06-04 17:06
 **/
public class QuickSort {

    public static int getIndex(int[] target, int start, int end) {

        int l = start;
        int r = end;

        int flag = target[start];
        while (l < r) {
            while (l <= r && target[l] <= flag) {
                l++;
            }
            while (l <= r && target[r] >= flag){
                r--;
            }

            if (l < r && target[l] > target[r]) {
                swap(target, l, r);
            }
        }
        swap(target, r, start);

        return r;
    }

    public static void quick(int[] target, int start, int end) {
        if (end <= start) {
            return;
        }
        int index = getIndex(target, start, end);
        quick(target, start, index - 1);
        quick(target, index + 1, end);
    }

    public static void main(String[] args) {
        int[] a = {1,3, 4, 5, 6, 1};
        quick(a, 0, a.length - 1);
        System.out.println(JSON.toJSONString(a));
    }

    private static void swap(int[] target, int a, int b) {
        int temp = target[a];
        target[a] = target[b];
        target[b] = temp;
    }
}
