//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组 
// 👍 289 👎 0

package first.leetcode.editor.cn;

public class code_59 {
    public static void main(String[] args) {
        Solution solution = new code_59().new Solution();

        System.out.println(solution.generateMatrix(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {

            int left = 0, right = n - 1, top = 0, bottom = n - 1;

            int[][] res = new int[n][n];
            int idx = 0;
            while (left <= right && top <= bottom) {
                for (int j = left; j <= right; j++) {
                    idx++;
                    res[top][j] = idx;
                }
                top ++;

                for (int i = top; i <= bottom; i++){
                    idx ++;
                    res[i][right] = idx;
                }
                right--;

                if (left <= right && top <= bottom){

                    for (int j = right; left <=j; j--){
                        idx ++;
                        res[bottom][j] = idx;
                    }
                    bottom --;

                    for (int i = bottom; i >= top; i--){
                        idx++;
                        res[i][left] = idx;
                    }
                    left ++;
                }

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}