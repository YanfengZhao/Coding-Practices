/*
A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Examples:
Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
*/

// Set the count to the length.
// Decrement count when a number doesn't satisfy.
// Use a flag to keep track the previous difference is positive, negative, or 0.

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length < 2){
            return length;
        }
        
        int count = length;
        Boolean flag = null;
        
        int prev = nums[0];
        for (int i = 1; i < length; i++){
            if (flag == null){
                if (nums[i] - prev > 0){
                    prev = nums[i];
                    flag = true;
                } else if (nums[i] - prev < 0){
                    prev = nums[i];
                    flag = false;
                } else {
                    count--;
                    continue;
                }
            }
            else if (flag == true){
                if (nums[i] - prev > 0){
                    prev = nums[i];
                    count--;
                } else if (nums[i] - prev < 0){
                    flag = false;
                    prev = nums[i];
                } else {
                    count--;
                    continue;
                }
            }
            else if (flag == false){
                if (nums[i] - prev < 0){
                    prev = nums[i];
                    count--;
                } else if (nums[i] - prev > 0){
                    flag = true;
                    prev = nums[i];
                } else {
                    count--;
                    continue;
                }
            }
        }
        return count;
    }
}

