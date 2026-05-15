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
        // add all the elements to a list to simplify the reordering
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        // reorder
        /*  case 1: 
            [0] 0 -> 6
            [1] 1 -> 5
            [2] 2 -> 4
            [3] 3 -> 4
            [4] 4 -> 3
            [5] 5 -> 2
            [6] 6 -> 0
            
            i = 3
            j = 3
            tmp = 3

            case 2:
            [0] 0 -> 2
            [1] 1 -> null
            [2] 2 -> 1
            
            i = 1
            j = 1
            tmp = 1

            0 -> 1 -> 2 -> null
            0 -> 2 -> 1 -> null

            case 3:
            [0] 0 -> 1
            [1] 1 -> null

            i = 1
            j = 0
            tmp = 1

            0 -> 1 -> null
            0 -> 1 -> null

        */
        int i = 0, j = list.size() - 1;
        while (i < j) {
            ListNode tmp = list.get(i).next;
            list.get(i).next = list.get(j);
            list.get(j).next = tmp;

            ++i;
            --j;

            // because case 3, we need i >= j instead of i == i
            if (i >= j) list.get(i).next = null;
        }
    }
}