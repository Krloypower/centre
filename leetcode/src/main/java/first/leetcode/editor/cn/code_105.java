//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 879 👎 0

package first.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class code_105 {
    public static void main(String[] args) {
        Solution solution = new code_105().new Solution();
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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int preLen = preorder.length;

            int inoLen = inorder.length;

            if (preLen != inoLen) {
                return null;
            }

            for (int i = 0; i < inoLen; i++) {
                map.put(inorder[i], i);
            }


            return buildTree(preorder, 0, preLen - 1, inorder, 0, inoLen - 1);
        }

        private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inoStart, int inoEnd) {
            if (preStart > preEnd || inoStart > inoEnd) {
                return null;
            }

            int val = preorder[preStart];
            TreeNode root = new TreeNode(val);

            int idx = map.get(val);

            root.left = buildTree(preorder, preStart + 1, idx - inoStart + preStart, inorder, inoStart, idx - 1);
            root.right = buildTree(preorder, idx - inoStart + preStart + 1, preEnd, inorder, idx + 1, inoEnd);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}