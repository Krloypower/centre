//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
//X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 479 👎 0

package first.leetcode.editor.cn;

public class code_130 {
    public static void main(String[] args) {
        Solution solution = new code_130().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int rows;
        int columns;

        public void solve(char[][] board) {
            rows = board.length;
            columns = board[0].length;

            for (int j = 0 ; j < columns ; j ++){
                dfs(board, 0, j);
                dfs(board, rows - 1, j);
            }

            for (int i = 0 ; i < rows ;i ++){
                dfs(board, i , 0);
                dfs(board, i , columns - 1);
            }

            for (int i = 0 ; i < rows; i++){
                for (int j = 0 ; j < columns; j++){
                    if (board[i][j]== 'A'){
                        board[i][j] = 'O';
                    }else {
                        board[i][j] = 'X';
                    }
                }
            }


        }

        private void dfs(char[][] board, int i, int j) {
            if (i < 0 || j < 0 || i > rows - 1 || j > columns - 1 || board[i][j] != 'O') {
                return;
            }
            board[i][j] = 'A';
            dfs(board, i - 1, j);
            dfs(board, i + 1, j);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}