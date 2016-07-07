/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

// Dynamic programming.
// Keep track of the letters which is the end of a word in an array.

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] cache = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++){
            if (i == 0 || cache[i-1] == true){
                for (int j = i+1; j <= s.length(); j++){
                    if (wordDict.contains(s.substring(i,j))){
                        cache[j-1] = true;
                    }
                }
            }
        }
        if (cache[s.length()-1] == true){
            return true;
        }
        return false;
    }
}
