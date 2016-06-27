/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
*/

// You really don't care about the numbers between m and n.
// Compare the 32 bits from the most significant bit.
// If a bit is different in m and n, make that bit and every bit after 0.

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 31;
        while (i >= 0){
            if (m >> i != n >> i){
                return m >> (i) << (i);
            }
            i--;
        }
        return m;
    }
}
