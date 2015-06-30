/*
Sort a linked list in O(n log n) time using constant space complexity.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // divide the list by half each time and deal with each each individual half recursively
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        // find the mid of list
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode firstHalf = head;
        
        while(p2!=null && p2.next!=null){
            firstHalf = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        firstHalf.next = null;
        
        // divide into subproblems
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(p1);
        
        return merge(n1,n2);
    }
    
    // merge the results and return
    public ListNode merge(ListNode n1, ListNode n2){
        if(n1 == null){
            return n2;
        }
        if(n2 == null){
            return n1;
        }
        ListNode preHead = new ListNode(-1);
        ListNode temp = preHead;
        while(n1!=null && n2!=null){
            if(n1.val > n2.val){
                temp.next = n2;
                n2 = n2.next;
                temp = temp.next;
            }
            else{
                temp.next = n1;
                n1 = n1.next;
                temp = temp.next;
            }
        }
        if(n1 == null){
            temp.next = n2;
        }
        else{
            temp.next = n1;
        }
        return preHead.next;
    }
}
