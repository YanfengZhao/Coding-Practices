/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

// cannot use double because not enough range.
// convert to long.
// if no reminder, simply output.
// other wise deal with reminder.

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // numerator is 0
        if (numerator == 0){
            return "0";
        }
        
        // denominator is 0
        if (denominator == 0){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        // result is negative
        if(numerator < 0 != denominator < 0){
            sb.append("-");
        }
        
        // convert int to long to avoid overflow or underflow
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // calculate quotient
        long quotient = num/den;
        sb.append(quotient);
        
        // if remainder is 0 return
        long remainder = num % den;
        if(remainder == 0){
            return sb.toString();
        }
        
        // if remainder is not 0, deal with decimal points
        else{
            sb.append(".");
            HashMap<Long,Integer> hm= new HashMap<Long,Integer>();
            // doens't need to check if remainder is 0 or not
            while(!hm.containsKey(remainder)){
                hm.put(remainder,sb.length());
                quotient = remainder*10/den;
                sb.append(quotient);
                remainder = remainder*10%den;
            }
            
            // insert parentheses anyways
            int index = hm.get(remainder);
            sb.insert(index,"(");
            sb.append(")");
            
            // if there is a repeating 0, it means there is no repeats at all,
            // so simply replace "(0)" with ""
            return sb.toString().replace("(0)","");
        }
    }
}
