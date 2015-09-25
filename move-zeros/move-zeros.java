/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

// Use insertion method. Move all none 0 numbers as forward as possible.
// Then fill out rest of the array with 0s.

public class Solution {
    public void moveZeroes(int[] nums) {
        int insertIndex = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i]!=0){
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        while(insertIndex < nums.length){
            nums[insertIndex] = 0;
            insertIndex++;
        }
    }
}
