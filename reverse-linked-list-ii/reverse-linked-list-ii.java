/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 // Make sure to keep track of the node before m (prev), node m, node n, and the node after (last) before start reversing
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n){
            return head;
        }
        
        // create preHead
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode prev = preHead;
        // find mth element and nth element
        int elementIndex = 1;
        ListNode temp = head;
        ListNode mth = head;
        ListNode nth = head;
        while (elementIndex != n){
            if(elementIndex == m){
                mth = temp;
            }
            // !!! this way to keep track of the node at m-1, works even if m = 0
            if(elementIndex < m){
                prev = temp;
            }
            elementIndex++;
            temp = temp.next;
        }
        
        nth = temp;
        
        ListNode last = nth.next;
        prev.next = last;
        
        // reverse mth to nth element
        while(mth != nth){
            temp = mth.next;
            mth.next = prev.next;
            prev.next = mth;
            mth = temp; 
        }
        
        nth.next = prev.next;
        prev.next = nth;
        return preHead.next;
    }
}
