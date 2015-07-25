/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

// Count the number of 5s in n add to counter.
// Divide n by 5 and repeat counting until n becomes 0.

public class Solution {
    public int trailingZeroes(int n) {
        int counter = 0;

        while(n!=0){
            counter+=n/5;
            n/=5;
        }
        return counter;
    }
}
