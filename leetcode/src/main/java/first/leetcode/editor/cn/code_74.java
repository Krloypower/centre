//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 303 👎 0

package first.leetcode.editor.cn;

public class code_74 {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix = {{1}};
        int target = 1;
        Solution solution = new code_74().new Solution();

        System.out.println(solution.searchMatrix(matrix, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            int row = matrix.length;
            int column = matrix[0].length;
            for (int i = 0; i < row; i++) {
                int start = 0;
                int end = column;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (mid > column - 1) {
                        break;
                    }
                    if (matrix[i][mid] < target) {
                        start = mid + 1;
                    } else if (matrix[i][mid] > target) {
                        end = mid - 1;
                    } else {
                        return true;
                    }
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}