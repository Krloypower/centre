package code.tree;

import code.common.NoUtil;

import  code.common.NoUtil.ListNode;


/**
 * @ClassName MergeTwoLists
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-06-11 10:10
 **/
public class MergeTwoLists {

    public static ListNode soultion(ListNode l1, ListNode l2){
        ListNode newNode = new ListNode();
        ListNode real = newNode;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                ListNode temp = l1;
                ListNode next = l1.next;
                newNode.next = temp;
                l1.next = null;
                l1 = next;
            }else {
                ListNode temp = l2;
                ListNode next = l2.next;
                newNode.next = temp;
                l2.next = null;
                l2 = next;
            }
            newNode = newNode.next;
        }
        if (l1 != null){
            newNode.next = l1;
        }
        if (l2 != null){
            newNode.next = l2;
        }
        return real.next;
    }

    public static void main(String[] args) {
        ListNode l1 = NoUtil.createNodeHead(new int[]{1, 2, 4});
        ListNode l2 = NoUtil.createNodeHead(new int[]{1, 3, 4});
        ListNode newNode = soultion(l1, l2);
        NoUtil.syuNode(newNode);
    }
}
