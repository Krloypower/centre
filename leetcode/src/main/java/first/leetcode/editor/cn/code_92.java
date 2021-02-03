//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表
// 👍 660 👎 0

package first.leetcode.editor.cn;

public class code_92 {
    public static void main(String[] args) {
        Solution solution = new code_92().new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int m = 3, n = 4;
        ListNode nodeHead = NoUtil.createNodeHead(nums);
        System.out.println(solution.reverseBetween(nodeHead, m, n));
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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode root = new ListNode(-1);
            root.next = head;
            ListNode pre = root;
            int temM = m;

            while (temM-- > 1) {
                pre = pre.next;
            }
            ListNode cur = pre.next;
            while (m++ < n) {
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }

            return root.next;
        }
    }
}