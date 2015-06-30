/*Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // add a new head to get rid of corner cases.
        // newHead(prev) -> temp0(head) -> temp1 -> end 
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode prev = newHead;
        ListNode temp0 = prev.next;
        
        while(temp0!=null && temp0.next!=null){
            ListNode temp1 = temp0.next;
            ListNode end = temp1.next;
            prev.next = temp1;
            temp1.next = temp0;
            temp0.next = end;
            
            prev = temp0;
            temp0 = prev.next;
        }
        return newHead.next;
    }
}
