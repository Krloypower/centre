//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 769 👎 0

package first.leetcode.editor.cn;

import java.util.Arrays;

public class code_56 {
    public static void main(String[] args) {
        Solution solution = new code_56().new Solution();

        int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};

        System.out.println(solution.merge(intervals));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {

            int[][] res = new int[intervals.length][2];

            Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

            int idx = -1;

            for (int[] interval : intervals) {
                if (idx == -1 || res[idx][1] < interval[0]) {
                    res[++idx] = interval;
                }else {
                    res[idx][1] = Math.max(res[idx][1] , interval[1]);
                }
            }

            return Arrays.copyOf(res, idx + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}