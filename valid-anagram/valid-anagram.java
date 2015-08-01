/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
*/

// Instead of using a hashmap, use an array is sufficient.

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charArr = new int[256];
        // store s in charArr map
        for(int i=0; i < s.length(); i++){
            charArr[s.charAt(i)]++;
        }
        // decrement count in charArr map with every char in t
        for(int i=0; i < t.length(); i++){
            charArr[t.charAt(i)]--;
        }
        // make sure everything in the charArr is 0
        for(int i=0; i < charArr.length; i++){
            if(charArr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
