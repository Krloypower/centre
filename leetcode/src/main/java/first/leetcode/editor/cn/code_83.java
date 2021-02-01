//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 460 👎 0

package first.leetcode.editor.cn;

import code.common.NoUtil;

public class code_83 {
    public static void main(String[] args) {
        Solution solution = new code_83().new Solution();
        int[] nums = {1,1,2,3,3};
        ListNode head = NoUtil.createNodeHead(nums);
        NoUtil.syuNode(head);
        solution.deleteDuplicates(head);
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
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            ListNode temp = head;
            while (temp != null && temp.next != null){
                if (temp.val == temp.next.val){
                    ListNode next = temp.next;
                    temp.next = next.next;
                    next.next =null;
                }else {
                    temp = temp.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}