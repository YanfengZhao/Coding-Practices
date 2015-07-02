/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

// First trim the starting spaces and ending spaces.
// Count backwards and find the first space, then return the counter

public class Solution {
    public int lengthOfLastWord(String s) {
        String trimed = s.trim();
        if (trimed.length() == 0){
            return 0;
        }
        int counter = 0;
        for(int i = trimed.length()-1; i>=0; i--){
            if(trimed.charAt(i) == ' '){
                break;
            }
            else{
                counter++;
            }
        }
        return counter;
    }
}
