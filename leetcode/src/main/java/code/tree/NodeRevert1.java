package code.tree;

import first.leetcode.editor.cn.ListNode;
import first.leetcode.editor.cn.NoUtil;

/**
 * @ClassName NodeRevert1
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/2/3
 * @Version 1.0
 **/
public class NodeRevert1 {

    public static void main(String[] args) {

        int[] head = {1,2,3,4,5};
        ListNode nodeHead = NoUtil.createNodeHead(head);
        NoUtil.syuNode(nodeHead);
        NoUtil.syuNode(revert(nodeHead));

    }

    public static ListNode revert(ListNode head){
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode pre = root.next;
        while (pre.next != null){
            ListNode next = pre.next;
            pre.next = next.next;
            next.next = root.next;
            root.next = next;
        }
        return root.next;
    }
}
