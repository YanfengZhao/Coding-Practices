/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// Write a wrapper class implementing Comparable interface override compareTo.
// Traverse every node and put them in the wrapper object.
// Create a priority queue, add all wrapped nodes in queue.
// Create a dummy node and get all elements out of queue and return dummy.next.

public class Solution {
    class Container implements Comparable<Container> {
    	ListNode node;
     
    	public Container(ListNode node) {
    		this.node = node;
    	}
     
    	@Override
    	public int compareTo(Container o) {
    		if (this.node.val > o.node.val) {
    			return 1;
    		} else if (this.node.val < o.node.val) {
    			return -1;
    		} else {
    			return 0;
    		}
    	}
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<Container> pq = new PriorityQueue<Container>();
        for(ListNode n:lists){
            while(n!=null){
                pq.add(new Container(n));
                n = n.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            cur.next = pq.poll().node;
            cur = cur.next;
            if(pq.peek() == null){
                cur.next = null;
            }
            else{
                cur.next = pq.peek().node;
            }
        }
        return dummy.next;
    }
}
