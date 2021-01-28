//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 757 👎 0

package first.leetcode.editor.cn;

public class code_79 {
    public static void main(String[] args) {

        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        String word = "ABCCED";


        Solution solution = new code_79().new Solution();

        System.out.println(solution.exist(board, word));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private char[][] board;

        private int row;

        private int column;

        private boolean[][] temp;

        private String word;

        private int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        public boolean exist(char[][] board, String word) {
            row = board.length;
            if (row <= 0) {
                return false;
            }
            column = board[0].length;
            this.word = word;
            this.board = board;
            temp = new boolean[row][column];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean dfs(int i, int j, int start) {
            if (start == word.length() - 1) {
                return board[i][j] == word.charAt(start);
            }
            for (int k = 0 ; k < 4 ; k++){
                if (board[i][j] == word.charAt(start)){
                    temp[i][j] = true;
                    int newI =  i + dir[k][0];
                    int newJ =  j + dir[k][1];

                    if (isTrue(newI, newJ) && !temp[newI][newJ]){
                        if (dfs(newI, newJ, start + 1)){
                            return true;
                        }
                    }
                    temp[i][j] = false;
                }
            }
            return false;
        }

        private boolean isTrue(int newI, int newJ){
            return newI >=0 && newI < row && newJ>= 0 && newJ < column;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}