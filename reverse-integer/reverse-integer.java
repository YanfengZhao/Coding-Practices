/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

// Instead of converting the integer to char array and reversing it, an easy way would be using
// math manipulation. 
// Get the least significant bit by mod add to result, then divide x by 10, multiply result by 10 for next round.
// Don't forget to divide the result by 10 for after the while loop.
// To deal with max int and min int problem, simply use a long for computation.
// If the result is less than min int or greater than max int, then return 0.

public class Solution {
    public int reverse(int x) {
        long result = 0;
        while(x!=0){
            result = result + x % 10;
            x/=10;
            result*=10;
        }
        result/=10;
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE){
        	return 0;
        }
        return (int)result;
    }
}
