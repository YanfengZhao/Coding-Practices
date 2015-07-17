/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

// Dynamic programming. O(n).
// M[i] = Max(M[i-1] , M[i-2]+M[i]);

public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] value = new int[nums.length];
        value[0] = nums[0];
        value[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < value.length; i++){
            value[i] = Math.max(value[i-1],value[i-2]+nums[i]);
        }
        return value[value.length-1];
    }
}
