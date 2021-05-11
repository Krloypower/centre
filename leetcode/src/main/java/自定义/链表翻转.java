package 自定义;

import first.leetcode.editor.cn.ListNode;
import first.leetcode.editor.cn.NoUtil;

/**
 * @ClassName 链表翻转
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/4/14
 * @Version 1.0
 **/
public class 链表翻转 {

    public static void main(String[] args) {
        int[] value = {1,2,3,4,5};
        ListNode head = NoUtil.createNodeHead(value);
        NoUtil.syuNode(head);

        ListNode revert = revert(head);
        NoUtil.syuNode(revert);

    }

    public static ListNode revert(ListNode node){
        if (node == null){
            return null;
        }
        ListNode root = new ListNode(0);
        root.next = node;
        ListNode p = node;

        while (p.next != null){
            ListNode next = p.next;
            p.next = next.next;
            next.next = root.next;
            root.next = next;
        }
        return root.next;
    }
}
