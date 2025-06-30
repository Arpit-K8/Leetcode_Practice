/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null ;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        while(fast!=null && slow!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                while(slow!=temp){
                    slow = slow.next;
                    temp = temp.next;
                }
                return slow;
            }
        }
        return null;
    }
}