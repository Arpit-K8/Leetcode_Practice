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
    public ListNode partition(ListNode head, int x) {
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode lTail = leftDummy;
        ListNode rTail = rightDummy;

        while (head != null) {
            if (head.val < x) {
                lTail.next = head;
                lTail = lTail.next;
            } else {
                rTail.next = head;
                rTail = rTail.next;
            }
            head = head.next;
        }

        // Connect the two partitions
        rTail.next = null; // avoid cycle
        lTail.next = rightDummy.next;

        return leftDummy.next;
    }
}