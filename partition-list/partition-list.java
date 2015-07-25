/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// Use 2 linked list. Traverse the original list, if node.val >= x, remove it from one list and append it to the second list.
// Append the second list to the end of the first list.

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode dummy2 = new ListNode(-1);
        ListNode prev2 = dummy2;
        while(head!=null){
            if(head.val >= x){
            	ListNode temp = head.next;
                prev.next = head.next;
                head.next = null;
                prev2.next = head;
                prev2 = prev2.next;
                head = temp;
            }
            else{
            	prev = prev.next;
                head = head.next;
            }
        }
        prev.next = dummy2.next; // connect the 2 list.
        return dummy.next;
    }
}
