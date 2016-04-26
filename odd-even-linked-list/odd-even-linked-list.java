/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Optimal solution. Pay attention to the condition in while loop.

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode evenHead = p2;
        while(p2 != null && p2.next != null){
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = evenHead;
        return head;
    }
}

// Another solution.
// Create 2 nodes and append odd and even nodes to those nodes.

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode dummy1 = new ListNode(-1);
        ListNode cur1 = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode cur2 = dummy2;
        boolean isOdd = true;
        while(head != null){
            if(isOdd == true){
                cur1.next = head;
                cur1 = cur1.next;
                head = head.next;
                isOdd = !isOdd;
            }
            else{
                cur2.next = head;
                cur2 = cur2.next;
                head = head.next;
                isOdd = !isOdd;
            }
        }
        cur2.next = null;
        cur1.next = dummy2.next;
        return dummy1.next;
    }
}
