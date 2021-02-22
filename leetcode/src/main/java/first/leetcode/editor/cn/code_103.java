//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 390 👎 0

package first.leetcode.editor.cn;

import java.util.*;

public class code_103 {
    public static void main(String[] args) {
        Solution solution = new code_103().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            boolean isLeft = true;

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> temp = new ArrayList<>();
                while (size-- > 0) {
                    TreeNode poll = queue.poll();
                    if (poll == null) {
                        continue;
                    }
                    TreeNode left = poll.left;
                    if (left != null) {
                        queue.offer(left);
                    }
                    TreeNode right = poll.right;
                    if (right != null) {
                        queue.offer(right);
                    }
                    if (isLeft) {
                        temp.add(poll.val);
                    } else {
                        temp.add(0, poll.val);
                    }
                }
                isLeft = !isLeft;
                res.add(temp);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}