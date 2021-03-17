//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 465 👎 0

package first.leetcode.editor.cn;

import java.util.*;

public class code_257 {
    public static void main(String[] args) {
        Solution solution = new code_257().new Solution();

        Integer[] values = {37, -34, -48, null, -100, -100, 48, null, null, null, null, -54, null, -71, -22, null, null, null, 8};
        TreeNode treeNode = NoUtil.createTreeNode(values);
        List<String> list = solution.binaryTreePaths(treeNode);
        System.out.println(list);
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

        List<String> res = new ArrayList<>();

        List<Integer> temp = new LinkedList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) {
                return res;
            }
            if (root.left == null && root.right == null) {
                temp.add(root.val);
                res.add(convert(temp));
                temp.remove(temp.size() - 1);
                return res;
            }
            temp.add(root.val);
            binaryTreePaths(root.left);
            binaryTreePaths(root.right);
            temp.remove(temp.size() - 1);
            return res;
        }

        private String convert(List<Integer> temp) {
            StringBuffer sb = new StringBuffer();
            for (Integer te : temp) {
                sb.append(te).append("->");
            }
            sb.delete(sb.length() - 2, sb.length());
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}