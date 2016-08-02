/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

// A simpler solution.

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++){
            int tmp = max; // Update min with the previously calculated max
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }
}

// keep track of current max and current min. After each round, update the result with current max.
// O(n) time, O(1) space.
// Remember for a negative number, save max for min to use later since max will be changed before min is changed.

public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= 0){
            	max = Math.max(max * nums[i], nums[i]);
            	min = Math.min(min * nums[i], nums[i]);
            }
            else{
                int temp = max; // save max for min to use later since max will be changed before min is changed
            	max = Math.max(min * nums[i], nums[i]);
            	min = Math.min(temp * nums[i], nums[i]);
            }
            result = Math.max(result,max); // update result after each number in the list is processed
        }
 
        return result;
    }
}
