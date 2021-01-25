### 解题思路
Java 单数组 遍历 使用或与操作

并不是特别好使

执行用时：
2 ms, 在所有 Java 提交中击败了94.08%
的用户
内存消耗：
38.3 MB, 在所有 Java 提交中击败了82.06%的用户

### 代码

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = 9, col = 9, box = 0, cur = 0;
        int[][] list = new int[9][9];

        int rowIndex = 0x001;
        int colIndex = 0x010;
        int boxIndex = 0x100;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') continue;
                box = (i / 3) * 3 + j / 3;

                cur = board[i][j] - '0' -1;

                if ((list[j][cur] & rowIndex) == rowIndex) return false;
                else list[j][cur] = list[j][cur] | rowIndex;

                if ((list[i][cur] & colIndex) == colIndex) return false;
                else list[i][cur] = list[i][cur] | colIndex;

                if ((list[box][cur] & boxIndex) == boxIndex) return false;
                else list[box][cur] = list[box][cur] | boxIndex;
            }
        }

        return true;
    }
}
```