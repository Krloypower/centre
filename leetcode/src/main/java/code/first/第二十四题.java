package code.first;

import first.leetcode.editor.cn.ListNode;

/**
 * @ClassName 第二十四题
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/1/11
 * @Version 1.0
 **/
public class 第二十四题 {

    public static ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode temp = pre;

        while (temp.next != null && temp.next.next != null){

            ListNode l = temp.next;
            ListNode r = temp.next.next;

            temp.next = r;
            l.next = r.next;
            r.next = l;
            temp = l;
        }
        return pre.next;
    }

    public static ListNode swapPairs1(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;

        head.next = swapPairs1(next.next);

        next.next = head;

        return next;
    }
}
