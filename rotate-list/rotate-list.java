/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 // O(N)
 // First find out the length, k mod length to figure out new k (make sure k isn't 0).
 // Then find the element k away from the end.
 // Lastly move the last k elements to the front of the linked list is trivial.
 
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        
        // calculate the length of linked list
        int length = 0;
        ListNode l = head;
        while(l!=null){
            l = l.next;
            length++;
        }
        
        // mod k
        k = k % length;
        
        if(k == 0){
            return head;
        }
        
        // find the node k away from end
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i = 0; i < k; i++){
            p1 = p1.next;
        }
        
        // p2 contains the start of the list of nodes to be rotated
        while(p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        ListNode newHead = p2.next;
        p2.next = null;
        p1.next = head;
        head = newHead;
        return head;
    }
}
