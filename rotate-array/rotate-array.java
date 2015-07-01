/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Hint:
Could you do it in-place with O(1) extra space?
*/

// The trick to solve this problem in O(N) time and O(1) space complexity:
// Reverse the different parts of the list 3 times.
// First time reverse the whole list, index 0 -> length - 1
// Second time reverse the previous result from index 0 -> k - 1
// Third time reverse the previous result from index k -> length -1

public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    
    // reverse by swapping two elements at a time
    public void reverse(int[] nums, int l, int r){
        while(l<r){
        	int temp = nums[l];
        	nums[l] = nums[r];
        	nums[r] = temp;
        	l++;
        	r--;
        }
    }
}
