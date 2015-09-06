/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// Create a dummy node which has its next pointed to head.
// While head is not null, check every head against val.
// If equal, set prev.next = head.next.

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while(head!=null){
            if(head.val == val){
                prev.next = head.next;
            }
            else{
                prev = prev.next;
            }
  	    head = head.next;
        }
        return dummy.next;
    }
}
