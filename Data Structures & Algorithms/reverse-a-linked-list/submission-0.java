/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        /*
            3 -> 1  -> 4 -> null
            
            4 -> 1 -> 3 -> null
            tmp = 1, 4, null
            prev = 3, 1, 4
            head = 1, 4, null
         */
         ListNode prev = null;

         while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
         }

         return prev;
    }
}
