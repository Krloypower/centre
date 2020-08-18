package code.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName NoUtil
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-06-11 10:10
 **/
public class NoUtil {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void syuNode(ListNode head) {

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static ListNode createNodeHead(int[] values) {
        ListNode temp = new ListNode();
        ListNode head = temp;


        for (int i = 0; i < values.length; i++) {
            temp.val = values[i];
            if (i != values.length - 1) {
                ListNode next = new ListNode();
                temp.next = next;
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(2);

        ConcurrentHashMap<String ,String > map = new ConcurrentHashMap<>();
        map.put("1","2");
        LinkedList<String > linkedList = new LinkedList<>();
        list.add("11");
        list.add("11");
        list.add("11");
        list.add("11");

    }

}
