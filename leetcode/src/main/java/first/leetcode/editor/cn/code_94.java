//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 849 👎 0

package first.leetcode.editor.cn;


import java.util.*;

public class code_94 {
    public static void main(String[] args) {
        Solution solution = new code_94().new Solution();

        Integer[] value = {1,2,3,4,5,6,7};
        TreeNode treeNode1 = NoUtil.createTreeNode(value);
        TreeNode treeNode2 = NoUtil.createTreeNode(value);
        TreeNode treeNode3 = NoUtil.createTreeNode(value);

        System.out.println(solution.inorderTraversal3(treeNode1));
//        System.out.println(solution.inorderTraversal3(treeNode2));
        System.out.println(solution.inorderTraversal4(treeNode3));

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
        public List<Integer> inorderTraversal1(TreeNode root) {

            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }

        private void dfs(TreeNode root, List<Integer> res) {

            if (root == null) {
                return;
            }
            dfs(root.left, res);
            res.add(root.val);
            dfs(root.right, res);

        }

        // 中序遍历
        public List<Integer> inorderTraversal2(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> deque = new LinkedList<>();
            while (root != null || !deque.isEmpty()) {
                while (root != null) {
                    deque.push(root);
                    root = root.left;
                }
                root = deque.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }

        // 前序遍历
        public List<Integer> inorderTraversal4(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> deque = new LinkedList<>();
            while (root != null || !deque.isEmpty()) {
                while (root != null) {
                    res.add(root.val);
                    deque.push(root);
                    root = root.left;
                }
                root = deque.pop();
                root = root.right;
            }
            return res;
        }

        // 前序遍历
        public List<Integer> inorderTraversal3(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                res.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }

                if (root.left != null) {
                    stack.push(root.left);
                }
            }
            return res;
        }


        // 后序遍历
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> stack1 = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                root = stack.pop();
                stack1.push(root);

                if (root.left != null){
                    stack.push(root.left);
                }

                if (root.right != null){
                    stack.push(root.right);
                }
            }

            while (!stack1.isEmpty()) {
               res.add(stack1.pop().val);
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}