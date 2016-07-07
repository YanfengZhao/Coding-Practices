/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/

// Use & to get carry.
// Use ^ to get sum.

public class Solution {
    public int getSum(int a, int b) {
        // Iterate till no more carry left
        while (b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
