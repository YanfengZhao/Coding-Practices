/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Create a dummy head.
// A lot easier if you compare head with head.next instead of comparing with ones before.
// Need a nested loop to skip over duplicated nodes.

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
           return head; 
        }
        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;

        while(head!=null){
            if(head.next!=null && head.val == head.next.val){
            	while(head.next!=null && head.val == head.next.val){
            		head = head.next;
            	}
            }
            else{
            	curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        curr.next = null; // don't forget to set the last element's next to null
        return dummy.next;
    }
}
