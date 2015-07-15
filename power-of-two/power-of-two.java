/*
Given an integer, write a function to determine if it is a power of two.
*/

// Solution 1 simply divide n by 2 and make sure the mod isn't 1 (can't be power of 2). If n == 1, return true.
// Solution 2 converts n to binary. The binary number has to have 1 and only 1 "1" to be power of 2.

public class Solution {
    public boolean isPowerOfTwo(int n){
		if(n<=0){
			return false;
		}
		while(n > 0){
			if(n == 1){
				return true;
			}
			if(n%2 == 1){
				return false;
			}
			n/=2;
		}
		return true;
	}
    public boolean isPowerOfTwoS2(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
}
