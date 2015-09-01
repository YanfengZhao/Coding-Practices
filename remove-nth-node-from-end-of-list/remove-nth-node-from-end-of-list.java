/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Make a dummy head called prev which has its next pointed to the head.
// Have one pointer called p1 point n away from head.
// Create another pointer called p2 point to prev.
// While p1's next is not null, move p1 and p2 concurrently.
// Remove p2's next.
// Return prev's next which is the head.

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode p1 = head;
        ListNode prev = new ListNode(0);
        prev.next = head;
        while(n>1){
            p1=p1.next;
            n--;
            if(p1 == null){ // incase n > number of elements in the list
            	return head;
            }
        }
        ListNode p2 = prev;
        while(p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        p2.next = p2.next.next;
        return prev.next;
    }
}

// This is another solution similar to the first solution, but a little more clear

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        
        // move temp n away from head
        for(int i = 0; i < n; i++){
            if(temp == null){ // incase n > number of elements in the list
                return head;
            }
            temp = temp.next;
        }
        
        ListNode curr = head;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode prev = preHead;
        
        // move temp, prev, and curr concurrently if temp is not null
        while(temp != null){
            temp = temp.next;
            prev = prev.next;
            curr = curr.next;
        }
        
        // remove curr by setting prev.next to curr.next
        prev.next = curr.next;
        return preHead.next;
    }
}
