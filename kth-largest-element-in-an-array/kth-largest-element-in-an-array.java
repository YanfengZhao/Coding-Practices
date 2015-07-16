/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

// Use a priority queue (min-heap). O(n log k) time O(k) space.
// Make sure to keep priority queue at size k by removing the root when size is k+1.
// The element removed each time is the smallest in the heap.
// Lastly poll again to get the kth largest element.

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k+1);
        
        for(int i: nums){
        	pq.add(i);
        	if(pq.size() > k){
        		pq.poll();
        	}
        }
        
        return pq.poll();
    }
}
