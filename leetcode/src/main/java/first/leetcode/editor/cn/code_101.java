//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//    1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1229 👎 0

package first.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class code_101 {
    public static void main(String[] args) {
        Solution solution = new code_101().new Solution();
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
        public boolean isSymmetric1(TreeNode root) {
            return check(root, root);
        }

        private boolean check(TreeNode root, TreeNode root1) {
            if (root == null && root1 == null) {
                return true;
            }
            if (root == null || root1 == null) {
                return false;
            }

            return root.val == root1.val && check(root.left, root1.right) && check(root.right, root1.left);
        }

        public boolean isSymmetric(TreeNode root) {

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode left = root, right = root;

            queue.offer(left);
            queue.offer(right);
            while (!queue.isEmpty()) {
                left = queue.poll();
                right = queue.poll();

                if (left == null && right == null){
                    continue;
                }

                if (left == null || right == null || right.val != left.val) {
                    return false;
                }

                queue.offer(left.left);
                queue.offer(right.right);


                queue.offer(left.right);
                queue.offer(right.left);


            }

            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}