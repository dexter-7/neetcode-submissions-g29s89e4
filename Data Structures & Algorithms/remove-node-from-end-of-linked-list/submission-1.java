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

        /*
        when fast is null is because n points out to head
            cases:
                Input: head = [5], n = 1 Output: []
                Input: head = [1,2], n = 2 utput: [2]
        */
        if (fast == null) return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // remove nth node
        slow.next = slow.next.next;

        return head;
    }
}
