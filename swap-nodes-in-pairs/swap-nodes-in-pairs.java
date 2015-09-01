/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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

// Recursion. Deal with 2 nodes at a time.
// If head or head.next is null, return head since no swap will be performed.
// Otherwise swap the two nodes and return the first node.

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode last = head.next;
        head.next = swapPairs(last.next);
        last.next = head;
        return last;
    }
}

// Solution 2, iteratively.

public class Solution {
  public ListNode swapPairs(ListNode head) {
    ListNode start = new ListNode(0); //make head no longer a special case
    start.next = head;

    for(ListNode cur = start; cur.next != null && cur.next.next != null; cur = cur.next.next) {
      cur.next = swap(cur.next, cur.next.next);        
    }
    return start.next;
  }
  private ListNode swap(ListNode next1, ListNode next2) {
    next1.next = next2.next;
    next2.next = next1;
    return next2;
  }
}
