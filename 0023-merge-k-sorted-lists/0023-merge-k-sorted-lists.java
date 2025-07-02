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

    private ListNode Mergedll(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
            while(list1 != null){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;

            }
            while(list2 != null){
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;

            }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for(int i = 0; i < lists.length;i++){
            head = Mergedll(head,lists[i]);
        }    
        return head;
    }
}