/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenHeadA = getLength(headA);
        int lenHeadB = getLength(headB);
        
        while (lenHeadA>lenHeadB){
            headA=headA.next;
            lenHeadA--;
        }
        
        while (lenHeadA<lenHeadB){
            headB=headB.next;
            lenHeadB--;
        }
        
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        
        return headA;
    }
    
    private int getLength(ListNode head){
        if(head == null) return 0;
        int length = 0;
        ListNode currNode = head;
        while(currNode!=null){
            currNode = currNode.next;
            length++;
        }
        return length;
    }
}
