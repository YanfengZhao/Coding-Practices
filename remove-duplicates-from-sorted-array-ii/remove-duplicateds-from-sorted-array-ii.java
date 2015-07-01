/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

// similar to removing all duplicates, just need to add a size variable to see how many of the same number have occurred already

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int length = nums.length;
        int size = 0; // to keep track of number of duplicates
        for(int j = 1; j < nums.length; j++){
            if(nums[j]==nums[j-1]){
            	size++;
            	if(size>1){
            		length--;
            	}
            	else{
            		nums[i] = nums[j];
                    i++;
            	}
            }
            else{
                nums[i] = nums[j];
                i++;
                size = 0;
            }
        }
        return length;
    }
}
