/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Find midpoint node.
// Reverse the second half of list after the mid node.
// Merge the 2 lists.

public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        
        // find midpoint node
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        
        // reverse head2 list
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        while(head2!=null){
            ListNode temp = head2.next;
            head2.next = dummy.next;
            dummy.next = head2;
            head2 = temp;
        }

        head2 = dummy.next; 
     
        // merge the two lists

        ListNode head1 = head;
        while(head1!= null && head2!=null){
           dummy.next = head1;
           dummy = dummy.next;
           head1 = head1.next;
           dummy.next = head2;
           dummy = dummy.next;
           head2 = head2.next;
        }
        dummy.next = head1;
        dummy = dummy.next;
    }
}
