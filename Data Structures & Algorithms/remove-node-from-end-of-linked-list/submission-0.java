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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // logic to get into the nth node

        ListNode slow = head, fast = head;
        for (int i = 0; i < n; ++i) fast = fast.next;

        if (fast == null) return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // remove nth node
        slow.next = slow.next.next;

        return head;

        /*
                ListNode fast = head;
        ListNode slow = head;

        // Advance fast by n steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast is already null, we're removing the head
        if (fast == null) {
            return head.next;
        }

        // Move both until fast.next is null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;*/
    }
}
