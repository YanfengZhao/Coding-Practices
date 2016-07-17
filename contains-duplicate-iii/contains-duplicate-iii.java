/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
*/

// n^2 time limit exceeded solution
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2) return false;
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < Math.min(i+k+1, nums.length); j++){
                if (Math.abs((long)nums[i] - (long)nums[j]) <= t) return true;
                
            }
        }
        return false;
    }
}
