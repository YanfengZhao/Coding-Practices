/*
Reverse a singly linked list.
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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        // create a node before head help with reversing process
        ListNode preHead = null; // or ListNode preHead = new ListNode(); then later change all preHead to preHead.next
        
        ListNode cur = head;
        ListNode temp;
        
        while(cur!=null){
            temp = cur.next;
            cur.next = preHead;
            preHead = cur;
            cur = temp;
        }
        
        return preHead;
    }
}
