/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

// Use binary search to find a single instance of the element. If element doesn't exist, return -1 -1.
// If found, use linear probing to left and right until finding the last index with same element both ways. Return the pair.

public class Solution {
    public int[] searchRange(int[] nums, int target) {
		int[] result = {-1,-1};
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        boolean found = false;
        while(start<=end){
        	mid = (start+end)/2;
        	if(nums[mid] == target){
        		found = true;
        		break;
        	}
        	else if(target>nums[mid]){
        		start = mid + 1;
        	}
        	else if(target<nums[mid]){
        		end = end - 1;
        	}
        }
        
        // if not found, return -1, -1
        if(found == false){
        	return result;
        }
        
        // if found, then see where the sequence starts and ends
        int left = mid;
        int right = mid;
        while(left>=0 && nums[left]==target){
        	left--;
        }
        while(right<nums.length && nums[right]==target){
        	right++;
        }
        
        result[0] = left+1;
        result[1] = right-1;
        return result;
    }
}
