/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/

// 2 for loops, one calculates the product from index 0 to i-1.
// 2nd for loop calculates the product from n-1 to i+1.
// Multiple those 2 get you the result.

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i = 1; i < nums.length; i++){
            result[i] = result[i-1] * nums[i-1];
        }
        int rightEnd = 1;
        for(int i = nums.length-1; i >= 0; i--){
            result[i] *= rightEnd; 
            rightEnd = nums[i]*rightEnd;
        }
        return result; 
    }
}
