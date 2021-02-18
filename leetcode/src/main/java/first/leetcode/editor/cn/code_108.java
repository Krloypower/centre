//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 698 👎 0

package first.leetcode.editor.cn;

public class code_108 {
    public static void main(String[] args) {
        Solution solution = new code_108().new Solution();
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return dsf(nums, 0, nums.length - 1);
        }

        private TreeNode dsf(int[] nums, int l, int r) {
            if (l > r) {
                return null;
            }

            int mid = (l + r) / 2;

            TreeNode root = new TreeNode(nums[mid]);
            root.left = dsf(nums, l, mid - 1);
            root.right = dsf(nums, mid + 1, r);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}