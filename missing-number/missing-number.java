/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/

// Notice the nums array is not sorted.
// Use the check sum method.

public class Solution {
    public int missingNumber(int[] nums) {
        if(nums==null || nums.length == 0) return 0;
        int wouldBeSum = (nums.length+1)*nums.length/2; // (first+last)*length/2
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        return wouldBeSum-sum;
    }
}
