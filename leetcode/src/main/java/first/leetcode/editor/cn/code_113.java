//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 

// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 429 👎 0

package first.leetcode.editor.cn;

import java.util.*;

public class code_113 {
    public static void main(String[] args) {
        Solution solution = new code_113().new Solution();
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


    //
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1


    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
            dfs(root, targetSum);
            return res;
        }

        private void dfs(TreeNode root, int targetSum) {
            if (root == null) {
                return;
            }
            path.add(root.val);
            targetSum -= root.val;
            if (root.left == null && root.right == null && targetSum == 0) {
                res.add(new ArrayList<>(path));
            }
            dfs(root.left, targetSum);
            dfs(root.right, targetSum);
            path.remove(path.size() - 1);
        }



        // 栈实现
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            Deque<TreeNode> deque = new LinkedList<>();
            Deque<List<Integer>> temp = new LinkedList<>();

            deque.push(root);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            temp.push(list);

            while (!deque.isEmpty()) {
                root = deque.pop();
                List<Integer> pop = temp.pop();

                if (root.left == null && root.right==null && root.val == targetSum){
                    res.add(pop);
                }

                if (root.right != null){

                    pop.add(root.right.val);
                    temp.push(new ArrayList<>(pop));

                    root.right.val += root.val;
                    deque.push(root.right);
                    pop.remove(pop.size() - 1);
                }

                if (root.left != null){

                    pop.add(root.left.val);
                    temp.push(new ArrayList<>(pop));

                    root.left.val += root.val;
                    deque.push(root.left);
                    pop.remove(pop.size() - 1);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}