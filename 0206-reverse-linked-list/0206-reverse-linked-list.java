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
        ListNode nextnext = null, prev = null, curr = head;
        while(curr!=null){
            nextnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextnext;
        }
        head = prev;
        return head;
    }
}