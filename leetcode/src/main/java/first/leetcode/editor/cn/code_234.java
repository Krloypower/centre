//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 879 👎 0

package first.leetcode.editor.cn;

public class code_234 {
    public static void main(String[] args) {
        Solution solution = new code_234().new Solution();
        int[] values = {1, 2, 2, 1};
        ListNode nodeHead = NoUtil.createNodeHead(values);
        System.out.println(solution.isPalindrome(nodeHead));
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
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            ListNode first = fastAndSlow(head);
            ListNode send = revert(first.next);

            while (send != null) {
                if (head.val != send.val){
                    return false;
                }
                send = send.next;
                head = head.next;
            }
            return true;
        }

        public ListNode fastAndSlow(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public ListNode revert(ListNode head) {
            ListNode pre = head;
            while (head != null && head.next != null) {
                ListNode temp = head.next;
                head.next = head.next.next;
                temp.next = pre;
                pre = temp;
            }

            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}