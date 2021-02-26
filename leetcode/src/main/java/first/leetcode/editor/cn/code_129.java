//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。 
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。 
//
// 计算从根到叶子节点生成的所有数字之和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25. 
//
// 示例 2: 
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026. 
// Related Topics 树 深度优先搜索 
// 👍 321 👎 0

package first.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class code_129 {
    public static void main(String[] args) {
        Solution solution = new code_129().new Solution();
        Integer[] nums = {4, 9, 0, 5, 1};
        TreeNode treeNode = NoUtil.createTreeNode(nums);
        System.out.println(solution.sumNumbers(treeNode));
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
        public int sumNumbers2(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode root, int prvSum) {
            if (root == null) {
                return 0;
            }
            int sum = prvSum * 10 + root.val;
            if (root.left == null && root.right == null) {
                return sum;
            } else {
                return dfs(root.left, sum) + dfs(root.right, sum);
            }
        }

        public int sumNumbers(TreeNode root) {

            Deque<TreeNode> deque =  new LinkedList<>();

            Deque<Integer> temp = new LinkedList<>();

            deque.push(root);
            temp.push(root.val);

            int sum = 0;

            while (!deque.isEmpty()){
                root = deque.pop();
                Integer pop = temp.pop();
                if (root.left == null && root.right == null){
                    sum += pop;
                }

                if (root.right != null){
                    deque.push(root.right);
                    temp.push(pop * 10 + root.right.val);
                }

                if (root.left != null){
                    deque.push(root.left);
                    temp.push(pop * 10 + root.left.val);
                }
            }


            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}