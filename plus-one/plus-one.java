/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

// if the result overflows, create a new array starting with 1, copy the rest of the array as it is

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;
            
        int carry = 0;
        digits[digits.length-1] += 1;
        if(digits[digits.length-1]>9){
        	carry = 1;
        	digits[digits.length-1] %= 10;
        }
        for(int i = digits.length-2; i >= 0; i--){
            if(digits[i]+carry <= 9){
                digits[i] = digits[i]+carry;
                carry = 0;
                break;
            }
            else{
                digits[i] = (digits[i]+carry)%10;
                carry = 1;
            }
        }
        
        // deal with overflow 
        if(carry == 1){
        	int[] arr = new int[digits.length+1];
        	arr[0]=1;
        	for(int i = 1; i < arr.length; i++){
        		arr[i] = digits[i-1];
        	}
        	return arr;
        }

        return digits;
    }
}
