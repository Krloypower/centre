//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 437 👎 0

package first.leetcode.editor.cn;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

public class code_82 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4, 5};
        ListNode nodeHead = NoUtil.createNodeHead(nums);
        NoUtil.syuNode(nodeHead);
        Solution solution = new code_82().new Solution();
        solution.deleteDuplicates(nodeHead);
        NoUtil.syuNode(nodeHead);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            if (head.val == head.next.val) {
                while (head != null && head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                return deleteDuplicates(head.next);
            }else {
                head.next = deleteDuplicates(head.next);
                return head;
            }
        }
//        public ListNode deleteDuplicates(ListNode head) {
//           ListNode root = new ListNode(0);
//           root.next = head;
//           ListNode cur = root;
//
//           while (cur.next!= null && cur.next.next != null){
//               if (cur.next.val == cur.next.next.val){
//                   ListNode temp = cur.next;
//                   while (temp !=null && temp.next != null && temp.val == temp.next.val){
//                        temp = temp.next;
//                   }
//                   cur.next = temp.next;
//               }else {
//                   cur = cur.next;
//               }
//           }
//
//           return root.next;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}