//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 528 👎 0

package first.leetcode.editor.cn;

public class code_143 {
    public static void main(String[] args) {
        Solution solution = new code_143().new Solution();

        int[] value = {1, 2, 3};
        int[] value1 = {5,4};
        ListNode nodeHead1 = NoUtil.createNodeHead(value);
        ListNode nodeHead2 = NoUtil.createNodeHead(value1);
        solution.marge(nodeHead1, nodeHead2);
//        solution.reorderList(nodeHead);
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
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }

            ListNode p = head;
            ListNode q = getQ(p);

            while (p.next != q || (q != null && q.next != null)) {
                ListNode temp = q.next;
                q.next = temp.next;
                temp.next = p.next;
                p.next = temp;
                p = temp.next;

                q = getQ(p);
            }

        }

        public ListNode getQ(ListNode p) {

            if (p.next != null && p.next.next != null) {
                ListNode q = p;
                while (q.next.next != null) {
                    q = q.next;
                }
                return q;
            } else {
                return p.next;
            }

        }

        public void marge (ListNode l1, ListNode l2){
            ListNode temp = l1;
            while (l1 != null && l2 != null){
                ListNode l1_next = l1.next;
                ListNode l2_next = l2.next;

                l1.next =l2;
                l2.next = l1_next;
                l2 = l2_next;
                l1 = l1_next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}