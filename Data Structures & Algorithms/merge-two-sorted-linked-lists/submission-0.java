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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1) check if one of the lists is null or empty
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // 2) know the head
        ListNode head = null;
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;   
        }

        ListNode tail = head;
/*
head  = list1 1r -> 1g -> 2r -> 3g -> 4r -> 5g -> null
list1 = 1r / 2r / 4r null
list2 = 1g 3g 5g
tail  = 1r / 1g / 2r / 3g / 4r
*/
        // merge both list
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1; // keep move: tail.next
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next; // keep move: tail.next
        }

        // one of them still have values not merded
        if (list1 == null) tail.next = list2;
        else tail.next = list1;

        return head;
    }
}