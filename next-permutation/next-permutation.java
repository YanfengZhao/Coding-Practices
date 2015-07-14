/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

// goal is to find the next permutation which increase the number the least
// (1.) find the longest decreasing suffix.
// (2.) identify index of the pivot, start of (1.) - 1.
// (3.) from right to left, identify the first element that's greater than the pivot.
// (4.) swap the 2 elements.
// (5.) reverse suffix.

public class Solution {
    	public void nextPermutation(int[] nums) {
        boolean found = false;
        int pivot = nums.length-1;
        for(int i = nums.length-2; i >= 0; i--){
        	if(nums[i]<nums[i+1]){
        		pivot = i;
        		found = true;
        		break;
        	}
        }
        if(!found){
        	Arrays.sort(nums);
        	return;
        }
        
        // from right to left find first element greater than pivot
        int swapIndex = 0;
        for(int i = nums.length-1; i > pivot; i--){
        	if(nums[i]>nums[pivot]){
        		swapIndex = i;
        		break;
        	}
        }
        
        // swap the 2 elements
        swap(nums,swapIndex,pivot);
        
        
        // reverse suffix
        int start = pivot + 1;
        int end = nums.length-1;
        while(start<end){
        	swap(nums,start,end);
        	start++;
        	end--;
        }
//      for(int k: nums){
//    		System.out.println(k);
//    	}
    }
	
	public void swap(int[] nums, int a, int b){
		int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
	}
}
