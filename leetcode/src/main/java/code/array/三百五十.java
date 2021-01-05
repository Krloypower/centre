package code.array;

import java.util.*;

/**
 * @ClassName 三百五十
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/12/9
 * @Version 1.0
 **/
public class 三百五十 {

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums1) {
            Integer count = map.get(a);
            if (count == null) {
                map.put(a, 1);
            } else {
                map.put(a, ++count);
            }
        }
        List<Integer> result = new ArrayList<>();

        for (int b : nums2) {
            Integer integer = map.get(b);
            if (integer != null && integer > 0) {
                result.add(b);
                map.put(b, --integer);
            }
        }
        int[] i = new int[result.size()];
        for (int j = 0; j < result.size(); j++) {
            i[j] = result.get(j);
        }
        return i;
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result.add(nums1[i]);
                i++;
                j++;

            }
        }

        int[] k = new int[result.size()];
        for (int l = 0; l < result.size(); l++) {
            k[l] = result.get(l);
        }
        return k;
    }

    public static void main(String[] args) {
        int[] i = new int[]{1, 2, 3, 4, 5};
        int[] j = new int[]{2, 3, 5};
        int[] intersect = intersect2(i, j);
        System.out.println(intersect);
    }
}
