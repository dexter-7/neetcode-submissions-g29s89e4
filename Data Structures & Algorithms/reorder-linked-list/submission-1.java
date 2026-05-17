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
    public void reorderList(ListNode head) {
        /*
            [0, 1, 2, 3, 4, 5, 6]
            1) use low, fast pointer to know the middle. In this case slow will stop at 3.

            2) reverse list starting at slow.next [4, 5, 6] => [6, 5, 4]

            3) merge
        */
        // 1)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) 4 -> 5 -> 6 -> null
        ListNode l1 = head, l2 = slow.next;
        ListNode prev = null, tmp;
        slow.next = null; // check if this help
        
        // prev points out to head of second list
        while (l2 != null) {
            tmp = l2.next;
            l2.next = prev;
            prev = l2;
            l2 = tmp;
        }
        l2 = prev;

        // merge
        while (l2 != null) {
            // we are going to replace both next, we need to back up them
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;

            l1.next = l2;
            l2.next = tmp1;

            l1 = tmp1;
            l2 = tmp2;
        }
        /*
            0)
            1 -> 2 -> null
            3 -> null

            1) in this case l2 = null, hence logic do not execute reverse or merge
            1 -> null
            -> null
        */
    }
}
