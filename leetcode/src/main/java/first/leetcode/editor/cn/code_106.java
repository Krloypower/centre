//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 446 👎 0

package first.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class code_106 {
    public static void main(String[] args) {
        Solution solution = new code_106().new Solution();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        System.out.println(solution.buildTree(inorder, postorder));
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
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int inoLen = inorder.length - 1;
            int postLen = postorder.length - 1;
            if (inoLen != postLen) {
                return null;
            }

            for (int i = 0; i <= inoLen; i++) {
                map.put(inorder[i], i);
            }

            return buildTree(inorder, 0, inoLen, postorder, 0, postLen);
        }

        private TreeNode buildTree(int[] inorder, int inoStart, int inoEnd, int[] postorder, int postStart, int postEnd) {

            if (inoStart > inoEnd || postStart > postEnd) {
                return null;
            }
            int val = postorder[postEnd];
            TreeNode root = new TreeNode(val);
            int idx = map.get(val);
            root.left = buildTree(inorder, inoStart, idx - 1, postorder, postStart, postEnd - inoEnd + idx - 1);
            root.right = buildTree(inorder, idx + 1, inoEnd, postorder, postEnd - inoEnd + idx, postEnd - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}