/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/

// Trick of this problem is start the length at the original length of nums, then decrement.
// Keep track of two indexes:
// first is the index you are altering which starts at index 1, another is the index you are currently on j.
// If the index you are currently on is equal to the one before, length--, increment the index you are on.
// If not equal, set nums[i] = nums[j], increment i and j.

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int length = nums.length;
        for(int j = 1; j < nums.length; j++){
            if(nums[j]==nums[j-1]){
                length--;
            }
            else{
                nums[i] = nums[j];
                i++;
            }
        }
        return length;
    }
}
