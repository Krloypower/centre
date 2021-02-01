//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 

// 
// Related Topics 链表 双指针 
// 👍 357 👎 0

package first.leetcode.editor.cn;

import code.common.NoUtil;

import java.util.List;


public class code_86 {
    public static void main(String[] args) {
        Solution solution = new code_86().new Solution();
        int[] nums = {1, 4, 3, 0, 2, 5, 2};
        ListNode head = NoUtil.createNodeHead(nums);
        NoUtil.syuNode(head);
        solution.partition(head, 3);
        NoUtil.syuNode(head);

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

//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5


    class Solution {
        public ListNode partition(ListNode head, int x) {

            ListNode root = new ListNode(-1);
            root.next = head;

            ListNode slow = root;
            while (slow.next != null && slow.next.val < x){
                slow = slow.next;
            }

            ListNode fast = slow.next;

            while (fast != null && fast.next != null) {
                if (fast.next.val < x){
                    ListNode fastNext = fast.next;
                    ListNode slowNext = slow.next;
                    fast.next = fast.next.next;
                    slow.next = fastNext;
                    fastNext.next = slowNext;
                    slow = slow.next;
                }else {
                    fast = fast.next;
                }
            }



//
//            while (fast != null && fast.next != null) {
//                if (slow.next.val < x) {
//                    slow = slow.next;
//                    fast = fast.next;
//                } else if (fast.next.val < x) {
//                    ListNode fastNext = fast.next;
//                    ListNode slowNext = slow.next;
//                    fast.next = fast.next.next;
//                    slow.next = fastNext;
//                    fastNext.next = slowNext;
//                    slow = slow.next;
//                }else {
//                    fast = fast.next;
//                }
//            }

            return root.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}