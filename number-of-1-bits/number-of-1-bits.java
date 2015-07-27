/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/

// while the number is not 0, check the least significant bit, if 1, increment counter.
// Logical shift the number to the right and continue until the number becomes 0.

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counter = 0;
        while(n!=0){
            if((n & 1) == 1) { // need to add parentheses around (n & 1)
                counter++;
            }
            n>>>=1; //logical shift not arithmetical shift. Logical shift add 0s in front as you shift to right.
        }
        return counter;
    }
}
