//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 582 👎 0




/*
[2,5]
[8,4]
[0,-1]

[[2,5,8],
[4,0,-1]]


 */

package first.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class code_54 {
    public static void main(String[] args) {
        Solution solution = new code_54().new Solution();

        int[][] matrix = {{2,5}, {8,4}, {0,-1}};
        System.out.println(solution.spiralOrder(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int rows = matrix.length;
            int columns = matrix[0].length;
            int left = 0, right = columns - 1, bottom = rows - 1, top = 0;
            List<Integer> res = new ArrayList<>();

            while (left <= right && top <= bottom) {

                for (int column = left; column <= right; column++) {
                    res.add(matrix[top][column]);
                }
                top++;

                for (int row = top; row <= bottom; row++) {
                    res.add(matrix[row][right]);
                }
                right--;

                if (top <= bottom && left <= right) {
                    for (int column = right; column >= left; column--) {
                        res.add(matrix[bottom][column]);
                    }
                    bottom--;

                    for (int row = bottom; row >= top; row--) {
                        res.add(matrix[row][left]);
                    }
                    left++;
                }

            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}