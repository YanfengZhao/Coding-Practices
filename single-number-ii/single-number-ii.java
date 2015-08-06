/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

// Solution 2: O(n) time. O(n) Memory.
// Calculate the sum of integers in nums.
// Add every integer in nums to hash set and find the sum of set.
// Multiply sum of set by 3 and subtract sum of nums and divide by 2.
// In case of overflow, use long for sum of nums and sum of set during calculation.

public class Solution {
    public int singleNumber(int[] nums) {
        
    }
    
    public int singleNumber2(int[] nums) {
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
