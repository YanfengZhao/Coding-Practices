/*
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers?
*/

// Use helper method to pass in 2 parameters.
// Use long instead of int for large inputs.
// Notice you can have a leading 0 when that's the only digit in your number.

public class Solution {
    public boolean isAdditiveNumber(String num){
		if(num.length() < 3) return false;
		for (int i = 1; i < num.length()-1; i++){
			String first = num.substring(0, i);
            String rest = num.substring(i, num.length());
            if (helper(first, rest)){
            	return true;
            }
		}
		return false;
	}
	public boolean helper(String first, String rest) {
        if(rest.length() < 2) return false;
        for (int i = 1; i < rest.length(); i++){
            String second = rest.substring(0, i);
            String third = rest.substring(i, rest.length());
            if (third.length() < first.length() || third.length() < second.length()){
                return false;
            }
            if(!checkVal(first, second, third)){
                continue;
            }
            long firstNum = Long.parseLong(first);
            long secondNum = Long.parseLong(second);
            long sumNum = firstNum+secondNum;
            String sum = sumNum+"";
            if (sum.equals(third.substring(0,sum.length()))){
                if(third.length() == sum.length()){
                    return true;
                } else {
                    if(!helper(second, third)){
						continue;
					}
					return true;
                }
            }
        }
        return false;
    }
    public boolean checkVal(String first, String second, String third) {
		return first.length() > 0 && second.length() > 0 && third.length() > 0
				&& (first.charAt(0) != '0' || first.length() == 1)
				&& (second.charAt(0) != '0' || second.length() == 1)
				&& (third.charAt(0) != '0' || third.length() == 1);
	}
}
