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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (head != null && fast != null) {
            slow = slow.next;
            
            if (fast.next == null) return false;
            fast = fast.next.next;

            if (slow == fast) return true; // cycle detected

            head = head.next;
        }
        return false;
    }
}
