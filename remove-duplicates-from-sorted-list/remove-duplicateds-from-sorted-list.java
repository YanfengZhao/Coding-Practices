/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Solution 1, without dummy head. This is the better method.

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.val == prev.val){
                prev.next = cur.next;
            }
            else{
                prev = prev.next;
            }
            cur = cur.next;
        }
        return head;
    }
}

// Solution 2. Create a dummy points to a head.

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head; // don't forget to set the dummy's next equal to head
        ListNode prev = dummy;
        
        // make sure you don't compare the dummy node value against the real head value
        if(head!=null){
            prev = prev.next;
            head = head.next;
        }
        
        while(head!=null){
            if(prev.val == head.val){
                prev.next = head.next;
                head = head.next;
            }
            else{
                prev = prev.next;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
