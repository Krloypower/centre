package code.tree;

import code.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName 一百零二
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/12/11
 * @Version 1.0
 **/
public class 一百零二 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        TreeNode head = new TreeNode(0);
        head.left = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            while (size -- > 0){
                TreeNode remove = queue.remove();
                TreeNode left = remove.left;
                if (left != null){
                    temp.add(left.val);
                    queue.add(left);
                }
                TreeNode  right = remove.right;
                if (right != null){
                    temp.add(right.val);
                    queue.add(right);
                }
            }
            if (temp.size() > 0){
                result.add(temp);
            }
        }

        return result;
    }


}
