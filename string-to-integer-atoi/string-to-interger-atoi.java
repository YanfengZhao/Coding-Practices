/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
*/

public class Solution {
    public int myAtoi(String str) {
        int index = 0;
        int sign = 1;
        char ch;
        int digit;
        int total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;
        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
        {
            index ++;
        }
        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-')
        {
            if(str.charAt(index) == '+')
                sign = 1;
            else
                sign = -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length())
        {
            ch = str.charAt(index);
            if(ch < '0' || ch > '9') break;
            digit = ch - '0';
            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;

            total = 10*total + digit;
            index ++;
        }
        return total * sign;
    }
}
