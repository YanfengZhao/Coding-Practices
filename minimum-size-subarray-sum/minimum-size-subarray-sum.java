/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
*/

// Uses 2 pointer. Keep track of the current minimum count >= s. If doesn't exist, keep it as nums.length+1.
// Everytime you found a sum >= s, subtract number at p1 from sum, 
// and increment p1 see if you can still be greater than s without the number.
// If sum is not >= s, increment p2 until reaches end of array or sum >= s again.

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int p1 = 0;
        int p2 = 0;
        int minCount = nums.length+1; // just like setting the integer to Integer.max. Has to be 1 greater than length of nums
        int sum = nums[0];
        
        while(p2 < nums.length && p1 <= p2){
        	if(sum < s){
        		p2++;
        		if(p2 < nums.length){
        			sum += nums[p2];
        		}
        	}
        	else{
        		minCount = Math.min(p2-p1+1, minCount);
        		sum -= nums[p1];
        		p1++;
        	}
        }
        
        if(minCount == nums.length+1){
        	return 0;
        }
        return minCount;
    }
}
