/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

// convert to all lower case, create StringBuffer and append the word in there character by character backwards, then compare the 2 strings.

public class Solution {
    public boolean isPalindrome(String s) {
        String lowercase = s.toLowerCase();
        StringBuffer strBuf = new StringBuffer();
        for(int i = 0; i < lowercase.length() ; i++){
            if((lowercase.charAt(i)>='a' && lowercase.charAt(i)<='z' )|| (lowercase.charAt(i)>='0' && lowercase.charAt(i)<='9')){
                strBuf.append(lowercase.charAt(i));
            }
        }
        if(strBuf.toString().equals(strBuf.reverse().toString())) return true;
        else return false;
    }
}
