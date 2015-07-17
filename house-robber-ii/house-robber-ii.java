/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

// Dynamic programming. O(n).
// M[i] = Max(M[i-1] , M[i-2]+M[i]);
// Execute this twice, once select the last house but not first, once select the first house but not last.
// Can save some space by keeping track the variable M[i], M[i-1], and M[i-2] instead of using an array.

public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        
        // start from first house and not include last
        int[] value = new int[nums.length-1];
        value[0] = nums[0];
        value[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < value.length; i++){
            value[i] = Math.max(value[i-1],value[i-2]+nums[i]);
        }
        int fromFirst = value[value.length-1];
        
        // start from second house and include last
        int[] value2 = new int[nums.length];
        value2[0] = 0;
        value2[1] = nums[1];
        value2[2] = Math.max(nums[1], nums[2]);
        for(int i = 3; i < value2.length; i++){
            value2[i] = Math.max(value2[i-1],value2[i-2]+nums[i]);
        }
        int fromLast = value2[nums.length-1];
        return Math.max(fromFirst, fromLast);
    }
}
