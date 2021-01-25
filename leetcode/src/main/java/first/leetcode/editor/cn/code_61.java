//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针 
// 👍 396 👎 0

package first.leetcode.editor.cn;

import java.util.List;

public class code_61 {
    public static void main(String[] args) {
        Solution solution = new code_61().new Solution();

        int[] list = {1, 2};
        ListNode nodeHead = NoUtil.createNodeHead(list);
        NoUtil.syuNode(nodeHead);
        ListNode listNode = solution.rotateRight(nodeHead, 1);
        NoUtil.syuNode(listNode);
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }
            ListNode node1 = head, node2 = head;
            int len = 1;
            while (node1.next != null) {
                node1 = node1.next;
                len++;
            }
            node1.next = node2;

            int start = len - k % len;

            while (start > 1){
                node2 = node2.next;
                start --;
            }
            ListNode res = node2.next;
            node2.next = null;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}