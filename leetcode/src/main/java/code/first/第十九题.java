package code.first;

import code.common.NoUtil.*;

/**
 * @ClassName 第十九提
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/8
 * @Version 1.0
 **/
public class 第十九题 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode start = pre, end = pre;

        while (n != 0) {
            end = end.next;
            n--;
        }

        while (end.next != null) {
            start = start.next;
            end = end.next;
        }


        start.next = start.next.next;

        return pre.next;
    }
}
