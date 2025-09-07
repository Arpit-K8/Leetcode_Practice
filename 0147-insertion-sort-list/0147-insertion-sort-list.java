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
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            sorted = sortedInsert(sorted, curr);
            curr = next;
        }
        return sorted;
    }
    private ListNode sortedInsert(ListNode sorted, ListNode newNode) {
        // Special case for the head end
        if (sorted == null || sorted.val >= newNode.val) {
            newNode.next = sorted;
            return newNode;
        }
        ListNode curr = sorted;
        // Locate the node before the point of insertion
        while (curr.next != null && curr.next.val < newNode.val) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        return sorted;
    }
}