/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// O(n). An easy way to solve this is using create a dummy head.
// Instead of adding the numbers and put into l1 or l2, just add them with carry and create a new node each time.
// Notice the while loop is "while(l1 != null || l2 != null)", so as long as one is not empty, it keeps running.
// Just have to check in while loop before adding to sum to see whether l1 or l2 is null or not.

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = 0;
            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            sum += carry;
            if(sum>9){
                carry = 1;
            }
            else{
                carry = 0;
            }
            sum %= 10;
            ListNode temp = new ListNode(sum);
            curr.next = temp;
            curr = curr.next;
        }
        if(carry>0){
            curr.next = (new ListNode(1));
        }
        return dummy.next;
    }
}

// Solution 2 has more complexed code, but the time efficiency is still O(n).

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while(l1!=null && l2!=null){
            int sum = l1.val+l2.val+carry;
            if(sum>9){
                sum = sum % 10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            ListNode n = new ListNode(sum);
            temp.next = n;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1!=null){
            while(l1!=null){
                int sum = l1.val+carry;
            if(sum>9){
                sum = sum % 10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            ListNode n = new ListNode(sum);
            temp.next = n;
            temp = temp.next;
            l1 = l1.next;
            }
        }
        if(l2!=null){
            while(l2!=null){
                int sum = l2.val+carry;
            if(sum>9){
                sum = sum % 10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            ListNode n = new ListNode(sum);
            temp.next = n;
            temp = temp.next;
            l2 = l2.next;
            }
        }
        if(carry==1){
            ListNode n = new ListNode(1);
            temp.next = n;
            temp = temp.next;
        }
        return dummy.next;
    }
}
