package code.first;

import code.common.TreeNode;
import org.omg.CORBA.IRObject;

/**
 * @ClassName 第一百零一题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/11
 * @Version 1.0
 **/
public class 第一百零一题 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);

    }
}
