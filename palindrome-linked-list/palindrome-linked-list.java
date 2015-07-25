/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// O(n) time and O(1) space.
// Split the linked list in half, reverse the second half of the linked list.
// Compare the 2 list node by node until one of the list is empty or the 2 node values aren't equal.

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        
        // reverse the second list
        ListNode dummy = new ListNode(-1);
        while(head2!=null){
            ListNode temp = head2.next;
            head2.next = dummy.next;
            dummy.next = head2;
            head2 = temp;
        }
        head2 = dummy.next;
        
        // compare the two list
        while(head!=null && head2!=null){
            if(head.val!=head2.val){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
}
