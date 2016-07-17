/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

// Solution 1. O(1) Space. O(n) Time, or 32*n.
// Traverse every bit of each number, add up the number of ones in the 0th bit, 1st bit...
// For each sum, % by 3. If that number is 1 or 2, then the corresponding bit in the result is 1.

public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++){
            int numOfOnes = 0;
            for (int j = 0; j < nums.length; j++){
                int lastBit = (nums[j] >> i) & 1;
                numOfOnes += lastBit;
            }
            numOfOnes %= 3;
            if (numOfOnes != 0){
                result |= 1<<i; 
            }
        }
        return result;
    }
}

// Solution 2: O(n) time. O(n) Memory.
// Calculate the sum of integers in nums.
// Add every integer in nums to hash set and find the sum of set.
// Multiply sum of set by 3 and subtract sum of nums and divide by 2.
// In case of overflow, use long for sum of nums and sum of set during calculation.

public class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        long sumOfNums = 0;
        for(int n:nums){
            hs.add(n);
            sumOfNums += n;
        }
        long sumOfSet = 0;
        for(int n:hs){
            sumOfSet += n;
        }
        return (int)((sumOfSet*3-sumOfNums)/2);
    }
}
