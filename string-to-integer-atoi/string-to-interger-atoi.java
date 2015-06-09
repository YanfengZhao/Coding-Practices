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

        //4. Conver number and avoid overflow
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
