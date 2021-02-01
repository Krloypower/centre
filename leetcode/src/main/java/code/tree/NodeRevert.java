package code.tree;

import code.common.NoUtil;
import first.leetcode.editor.cn.ListNode;

/**
 * @ClassName NodeRevert
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-06-11 08:32
 **/
public class NodeRevert {

    public static ListNode revert(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode revertDigui(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = revertDigui(head.next);
        head.next.next = head;
        head.next = null;

        return newNode;
    }

    public static ListNode jiaohuan(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;

        head.next = jiaohuan(next.next);
        next.next = head;
        return next;
    }


    public static void main(String[] args) {
        int[] temp = new int[]{1, 2, 8, 4, 5,6};
        ListNode head = NoUtil.createNodeHead(temp);
        NoUtil.syuNode(head);

//        ListNode revert = revert(head);
//        ListNode revert1 = revertDigui(head);

        ListNode jiaohuan = jiaohuan(head);
//        NoUtil.syuNode(revert);
//        NoUtil.syuNode(revert1);
        NoUtil.syuNode(jiaohuan);
    }
}
