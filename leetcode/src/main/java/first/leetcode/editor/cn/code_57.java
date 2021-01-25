//给出一个无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
//
// 
//
// 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。 
// Related Topics 排序 数组 
// 👍 355 👎 0

package first.leetcode.editor.cn;

import java.util.Arrays;

public class code_57 {
    public static void main(String[] args) {
        Solution solution = new code_57().new Solution();
        int[][] intervals = {};
        int[] newInterval = {2,3};
        System.out.println(solution.insert(intervals, newInterval));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int length = intervals.length;
            int[][] res = new int[length + 1][2];
            int i = 0;
            int idx = 0;

            while (i < length && intervals[i][1] < newInterval[0]) {
                res[idx++] = intervals[i++];
            }
            while (i < length && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            res[idx++] = newInterval;
            while (i < length) {
                res[idx++] = intervals[i++];
            }
            return Arrays.copyOf(res, idx);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}