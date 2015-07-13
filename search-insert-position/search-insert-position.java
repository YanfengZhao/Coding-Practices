/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

// Solution 2 is trival O(n) time.
// Solution 1 is using binary search. O(log n) time.
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while(start <= end){
        	mid = (start + end)/2;
        	if(target == nums[mid]){
        		return mid;
        	}
        	else if(target > nums[mid]){
        		start = mid+1;
        	}
        	else{
        		end = mid-1;
        	}
        }
        if(nums[mid] < target){ // in this case the target is larger than every number in the list.
        	return mid+1;
        }
        else{
            return mid;
        }
    }
    
    public int searchInsertS2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
        	if(nums[i] >= target){
        		return i;
        	}
        }
        return nums.length;
    }
}
