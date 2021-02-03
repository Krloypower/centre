//爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。 
//
// 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。） 
//
// 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。 
//
// 如果有多个答案，你可以返回其中任何一个。保证答案存在。 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [1,1], B = [2,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：A = [1,2], B = [2,3]
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：A = [2], B = [1,3]
//输出：[2,3]
// 
//
// 示例 4： 
//
// 
//输入：A = [1,2,5], B = [2,4]
//输出：[5,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= B.length <= 10000 
// 1 <= A[i] <= 100000 
// 1 <= B[i] <= 100000 
// 保证爱丽丝与鲍勃的糖果总量不同。 
// 答案肯定存在。 
// 
// Related Topics 数组 
// 👍 150 👎 0

package first.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class code_888 {
    public static void main(String[] args) {
        int[] A = {1, 1};
        int[] B = {2, 2};
        Solution solution = new code_888().new Solution();
        System.out.println(solution.fairCandySwap(A, B));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fairCandySwapA(int[] A, int[] B) {
            int sumA = Arrays.stream(A).sum();
            int sumB = Arrays.stream(B).sum();

            int i = (sumA - sumB) / 2;
            Set<Integer> temp = new HashSet<>();
            for (int a : A) {
                temp.add(a);
            }

            int[] res = new int[2];
            for (int y : B) {
                int x = y + i;
                if (temp.contains(x)) {
                    res[0] = x;
                    res[1] = y;
                    break;
                }
            }
            return res;
        }

        public int[] fairCandySwap(int[] A, int[] B) {
            int sumA = Arrays.stream(A).sum();
            int sumB = Arrays.stream(B).sum();

            int temp = (sumA - sumB) / 2;

            Arrays.sort(A);
            Arrays.sort(B);
            int i = 0, j = 0;
            int[] res = new int[2];
            while (i < A.length && j < B.length) {
                int cur = A[i] - B[j];
                if (cur == temp) {
                    res[0] = A[i];
                    res[1] = B[j];
                    break;
                } else if (cur > temp) {
                    j++;
                } else {
                    i++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}