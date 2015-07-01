/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

// The following implementation set the first string as the prefix, or the key.
// Compare the key with every other string by calling findCommon().
// The method returns a string in which the 2 strings have in common and update the key with it.
// After comparing n-1 times, the key is the longest common prefix.

// Another approach is similar to bfs, where you compare the first character of every string 
// to each other, if all the same, compare the next character of each string, until one is different.

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            prefix = findCommon(prefix,strs[i]);
        }
        return prefix;
    }
    public String findCommon(String prefix, String s2){
        if(prefix.length() == 0 || s2.length() == 0){
            return "";
        }
        else{
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i != prefix.length() && i != s2.length()){
                if(prefix.charAt(i) == s2.charAt(i)){
                    sb.append(prefix.charAt(i));
                }
                else {
                    break;
                }
                i++;
            }
            return sb.toString();
        }
    }
}
