/* 
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // create a hashmap, key is the character, integer is the index of the last time this character appeared
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int length = 0; // keeps track of current longest sequence
        int start = 0; // keeps track of the index of where the current sequence start counting
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            // if this character appeared before, take the max of -->
            // (1) index where the current sequence start counting
            // (2) where the character last appeared + 1
            if(map.containsKey(c)){
                start = Math.max(start,map.get(c) + 1);
            }
            
            // for each character, update length with the max of
            // (1) previous stored length
            // (2) length from the last non-repeating character +1 (start) to the current character
            length = Math.max(length, i-start+1);
            map.put(c,i);
        }
        return length;
    }
}
