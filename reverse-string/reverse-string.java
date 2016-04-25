/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/

// iterative
public class Solution {
    public String reverseString(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

// recursive
public class Solution {
    public String reverseString(String s) {
        if(s.length() == 0){
            return "";
        }
        return reverseString(s.substring(1))+s.substring(0,1);
    }
}
