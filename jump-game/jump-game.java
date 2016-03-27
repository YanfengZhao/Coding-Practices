/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

// First set the reachable to the first element in the array.
// Keep track the the max reachable at all times.
// Iterate through every element.
// If an element is 0 (which means it's not advancing), also the reachable is not greater than the element's index,
// then return false.
// Update the max reachable with current element.
// If any element's reachable is greater than the nums array itself, return true.
// Lastly notice the last return statement doesn't matter return true or false.

public class Solution {
    public boolean canJump(int[] nums) {
        int reachable = nums[0];
        // iterate every element in nums
        for(int i = 0; i < nums.length-1; i++){
            // if current reachable is not greater than i and also i is 0,
            // then you not going anywhere, return false
            if(reachable <= i && nums[i] == 0){
                return false;
            }
            // update the reachable
            reachable = Math.max(nums[i]+i, reachable);
            
            // if reachable is longer than the nums array itself, then immediately return true;
            if(reachable >= nums.length-1){
                return true;
            }
        }
        return true;
    }
}

// Solution 2. Cause runtime stack overflow error.
// Not very efficient because of recursion.

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==0 || nums.length==1){
            return true;
        }
        return helper(nums, new boolean[nums.length], 0);
    }
    
    public boolean helper(int[] nums, boolean[] calc, int i){
        if(i == nums.length-1){
            return true;
        }
        
        if(i > nums.length-1 || nums[i] == 0){
            return false;
        }
        
        for(int j = 1; j<=nums[i]; j++){
            if(!calc[i+j]){
                calc[i+j] = true;
                if(helper(nums,calc,i+j)){
                    return true;
                }
            }
        }
        return false;
    }
}
