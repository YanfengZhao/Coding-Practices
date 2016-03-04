/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

// A O(log(n)) solution
// Binary search twice for the left most then the right most occurence.
// Only modification to the binary search is that once found,
// if seraching for left most, we update the newly found left most index
// and set the new right to mid -1.
// Do the same while looking for right most occurence.

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = -1;
        int rightIndex = -1;
        // search for left most target
        
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                leftIndex = mid;
                r = mid-1;
            }
            else if(nums[mid]<target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        
        l = 0;
        r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                rightIndex = mid;
                l = mid+1;
            }
            else if(nums[mid]<target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        
        return new int[]{leftIndex,rightIndex};
    }
}


// A O(n) solution
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
