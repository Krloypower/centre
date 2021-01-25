package code.first;

import code.common.TreeNode;
import com.sun.org.apache.regexp.internal.RE;

import java.util.Base64;

/**
 * @ClassName 第一百一十题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/11
 * @Version 1.0
 **/
public class 第一百一十题 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return balanced(root) != -1;
    }

    public int balanced(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = balanced(root.left);
        if (left == -1) {
            return -1;
        }

        int right = balanced(root.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;

    }


}
