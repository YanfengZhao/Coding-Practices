/*
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: you may assume that n is not less than 2.

Hint:

There is a simple O(n) solution to this problem.
You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
*/

// Take note of the hint given.
// Notice the multiplication of 3s make the largest product.
// if mod is 1, remove a 3 and multiply by 4.

public class Solution {
    public int integerBreak(int n) {
        if(n == 2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int numOfThrees = n/3;
        int mod = n%3;
        if(mod == 0){
            return (int)Math.pow(3,numOfThrees);
        }
        if(mod == 1){
            return (int)Math.pow(3,numOfThrees-1)*4;
        }
        else{
            return (int)Math.pow(3,numOfThrees)*2;
        }
    }
}
