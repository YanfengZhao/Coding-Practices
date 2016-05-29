/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

// Recursive solution.

public class Solution {
    public int findMin(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public int helper(int[] nums, int i, int j){
        if(nums[i] <= nums[j]){
            return nums[i];
        }
        return Math.min(helper(nums,i,(j+i)/2),helper(nums,(j+i)/2+1,j));
    }
}

// Binary search. log(n) time complexity.
// If mid is less than right, that means the min is somewhere on the left side.
// Else the min is on the right side.

public class Solution {
    public int findMin(int[] nums) {
       int l = 0; 
		int r = nums.length-1; 
		int mid = r/2; 
		while (l<r){ 
			if(nums[mid]<nums[r]){ 
				r=mid; 
			}else{ 
				l=mid+1; 
			} 
			mid=(l+r)/2; 
		} 
		return nums[l];  
    }
}
