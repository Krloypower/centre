package code.tree;

import code.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MaxDepth
 * @Description 二叉树最大深度
 * @Author ouyangkang
 * @Date 2020/7/28
 * @Version 1.0
 **/
public class MaxDepth {

    /**
     * @param root:
     * @Author ouyangkang
     * @Description 队列实现 BFS Breadth first search
     * @Date 2020/12/11
     * @return: int
     **/
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode treeNode = queue.remove();
                TreeNode left = treeNode.left;
                TreeNode right = treeNode.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
            count++;
        }
        return count;
    }

    /**
     * @param root: 
     * @Author ouyangkang
     * @Description 递归实现，不建议，会导致，栈溢出 dfs depth first search
     * @Date 2020/12/11
     * @return: int
     **/
    public static int solution2(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(solution2(root.left), solution2(root.right)) + 1;
    }





    public static void main(String[] args) {

        TreeNode A = new TreeNode(1);

        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        A.left = b;
        A.right = c;

        TreeNode d = new TreeNode(4);
        TreeNode f = new TreeNode(5);
        b.left = d;
        d.left = f;
        System.out.println(solution(A));
        System.out.println(solution2(A));
    }

}
