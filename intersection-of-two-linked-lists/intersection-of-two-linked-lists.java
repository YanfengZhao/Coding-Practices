/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

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

// Traverse both list at the same time. 
// If a becomes null, set it equal to the head of b.
// If b becomes null, set it eqaul to the head of a.
// Eventually a will be equal to b, either that's the intersection or null.

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        
        // keep the original linked list
        ListNode a = headA;
        ListNode b = headB;
        
        while(a != b){
            if(a == null){
                a = headB;
            }
            else{
                a = a.next;
            }
            if(b == null){
                b = headA;
            }
            else{
                b = b.next;
            }
        }
        
        return a;
    }
}

// Another solution.
// Kowning the tail of the two must be the same.
// Find the length of both lists.
// Shift the list so that the tails length match, and start to look for the intersection node by node.

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
