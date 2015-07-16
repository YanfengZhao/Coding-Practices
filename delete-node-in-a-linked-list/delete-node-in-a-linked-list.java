/*
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// shift the content in the next node into the previous node.
// remember to keep track of the previous node so at the end you can set the prev.next = null.

public class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        while(node.next!=null){
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}