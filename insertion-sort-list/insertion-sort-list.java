/*
Sort a linked list using insertion sort.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// O(n^2) time insertion sort.
// Create a dummy node that connects to nothing.
// Traverse the head through the list, for every node, compare to what is in the dummy list.
// If cur is null or head is less than cur value, append head to the location of cur
// by create a temp node store the next head node,
// head.next = cur;
// prev.next = head;
// head = temp;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        while(head != null){
            ListNode prev = dummy;
            ListNode cur = prev.next;
            while(cur != null && cur.val < head.val ){
                cur = cur.next;
                prev = prev.next;
            }
            ListNode temp = head.next;
            head.next = cur;
            prev.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
