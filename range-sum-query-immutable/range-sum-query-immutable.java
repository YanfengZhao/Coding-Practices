/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/

// Use the cummulative sum method.
// Create a new array called numSums that include all sums before plus itself.
// Be careful in sumRange method, if i == 0, return whatever at j index, else return
// numSums[j] - numSums[i-1] since you want to keep the value at the i index.

public class NumArray {
    private int[] numSums;
    public NumArray(int[] nums) {
        numSums = new int[nums.length];
        if(nums.length != 0){
           numSums[0] = nums[0]; 
        }
        
        for(int i = 1; i < nums.length; i++){
            numSums[i] = numSums[i-1]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) return numSums[j];
        else{
            return numSums[j] - numSums[i-1];
        }
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
