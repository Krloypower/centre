//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 538 👎 0

package first.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class code_145 {
    public static void main(String[] args) {
        Solution solution = new code_145().new Solution();
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
        List<Integer> res = new ArrayList<>();

        // 递归方式
        public List<Integer> postorderTraversal1(TreeNode root) {
            if (root == null) {
                return res;
            }
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            res.add(root.val);
            return res;
        }


        // 利用栈实现
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return res;
            }
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.push(root);
            while (!deque.isEmpty()) {
                root = deque.pop();
                res.add(0, root.val);
                if (root.left != null){
                    deque.push(root.left);
                }
                if (root.right != null){
                    deque.push(root.right);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}