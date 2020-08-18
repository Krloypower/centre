package code.tree;

import code.common.NoUtil;
import code.common.NoUtil.ListNode;

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



    public static void main(String[] args) {
        int[] temp = new int[]{1,2,3,4,5};
        ListNode head = NoUtil.createNodeHead(temp);
        NoUtil.syuNode(head);

        ListNode revert = revert(head);
        NoUtil.syuNode(revert);
    }
}
