/*
Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

// Integer less than 0 cannot be palindrome.
// Use a long to store the reverse of x to prevent integer overflow.
// If the reverse is equal to the original number, return true.

public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        long y = 0;
        int saved = x;
        while(x!=0){
            y = y + x%10;
            x/=10;
            y*=10;
        }
        y/=10;
        if((int)y==saved){
            return true;
        }
        else{
            return false;
        }
    }
}
