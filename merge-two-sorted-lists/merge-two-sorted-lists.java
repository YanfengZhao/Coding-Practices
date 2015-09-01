/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next = l1;
                l1=l1.next;
                curr=curr.next;
            }
            else{
                curr.next = l2;
                l2=l2.next;
                curr=curr.next;
            }
        }
        // if l1 is longer than l2
        while(l1!=null){
            curr.next = l1;
            l1=l1.next;
            curr=curr.next;
        }
        // if l2 is longer than l1
        while(l2!=null){
            curr.next = l2;
            l2=l2.next;
            curr=curr.next;
        }
        return dummy.next;
    }
}

// Solution 2, the difference is while(l1!=null || l2!=null)

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode curr = preHead;
        while(l1 != null || l2 != null){
            // if both not null
            if(l1 != null && l2 != null){
                if(l1.val<l2.val){
                    curr.next = l1;
                    l1 = l1.next;
                }
                else{
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }
            // if l1 != null && l2 == null
            else if(l1 != null){
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }
        return preHead.next;
    }
}
