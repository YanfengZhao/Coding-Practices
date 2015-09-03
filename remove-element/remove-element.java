/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

// Keep track of two indexes, first is the index you are altering, another is the index you are currently on

public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int length = nums.length;
        // traverse every element in array
        for(int j = 0; j < nums.length; j++){
            // if equal, don't increment i, replace the original value with something else, decrease length
            if(nums[j]==val){
                length--;
            }
            // else alter array, increase i index
            else{
                nums[i]=nums[j];
                i++;
            }
        }
        return length;
    }
}
