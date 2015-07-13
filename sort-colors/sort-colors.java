/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
*/

// This can be done in one pass.
// For Solution 1, the key is to keep 2 pointers, p1 points to the end of 0, p2 points to begining of 2.
// For solution 2, the key is to keep 2 pointers, p1 points to the start of 1, p2 points to start of 2.
// Solution 1 is more simple.

public class Solution {
    // red = 0, white = 1, blue = 2.
    public void sortColors(int[] nums) {
        int p1 = 0; // pointer points to the end of 0
        int p2 = nums.length-1; // pointer points to the beginning of 2
        for(int i = 0; i <= p2; i++){
        	if(nums[i] == 0){
        		swap(nums,i,p1);
        		p1++;
        	}
        	else if(nums[i] == 2){
        		swap(nums,i,p2);
        		p2--;
        		i--;
        	}
        }
    }
	public void swap(int[] nums, int i1, int i2){
		int temp = nums[i1];
		nums[i1] = nums[i2];
		nums[i2] = temp;
	}
	
	public void sortColorsS2(int[] nums) {
        int p1 = 0; // pointer points to the beginning of 1
        int p2 = 0; // pointer points to the beginning of 2
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] == 0){
        		nums[i] = nums[p2]; // save what's in p2 in i index, since we know i had 0 
        		nums[p2] = nums[p1]; // save location p1 inside location p2
        		nums[p1] = 0; // set location p1 to 0
        		// increase pointers 1 and 2
        		p1++; 
        		p2++;
        	}
        	else if(nums[i] == 1){
        		nums[i] = nums[p2]; // save what was in p2 in i since we know i contains 1
        		nums[p2] = 1;
        		p2++;
        	}
        }
    }
}
