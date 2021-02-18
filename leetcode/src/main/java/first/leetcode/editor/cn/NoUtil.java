package first.leetcode.editor.cn;

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

    public static TreeNode createTreeNode(Integer[] values) {
        return dfs(values, 0);
    }

    private static TreeNode dfs(Integer[] values, int index) {
        if (index > values.length - 1) {
            return null;
        }
        Integer value = values[index];
        if (value == null){
            return null;
        }
        TreeNode root = new TreeNode(value);
        root.left = dfs(values, (index * 2) + 1);
        root.right = dfs(values, (index * 2) + 2);
        return root;
    }


    public static void main(String[] args) {

        Integer[] values = {1,2,3,4,5,6,7,8};
        TreeNode treeNode = createTreeNode(values);
        ArrayList<String> list = new ArrayList<>(2);

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "2");
        LinkedList<String> linkedList = new LinkedList<>();
        list.add("11");
        list.add("11");
        list.add("11");
        list.add("11");

    }

}
