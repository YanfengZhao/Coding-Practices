/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

// be careful with what you are returning

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;
        for(int i = 0; i <= nums.length - 3; i++){
    		int start = i+1;
    		int end = nums.length-1;
    		while(start<end){
    			int sum = nums[i]+nums[start]+nums[end];
    			if(sum == target){
    				return target;
    			}
    			else if(sum > target){
    				end--;
    				if(Math.abs(target-sum)<closest){
    				    closest = Math.abs(target-sum);
    				    closestSum = sum; 
    				}
    			}
    			else{
    				start++;
    				if(Math.abs(target-sum)<closest){
    				    closest = Math.abs(target-sum);
    				    closestSum = sum; 
    				}
    			}
        	}
        }
        return closestSum;
    }
}
