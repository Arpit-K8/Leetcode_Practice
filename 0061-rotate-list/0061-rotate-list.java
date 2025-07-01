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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int length = 0; //  finding length;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Normalize k
        k %= length;
        if (k == 0) return head; // No rotation needed

        // Use two pointers (fast and slow) to find the new tail
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast is at the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Rotate the list
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }
}