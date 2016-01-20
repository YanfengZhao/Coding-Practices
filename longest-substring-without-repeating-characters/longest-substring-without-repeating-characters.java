/* 
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

// Solution 1, clean code but not most easy to understand

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

// Solution 2, easy to understand

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int curCount = 0;
        int newStart = 0;
        if(s == null || s.length() == 0){
            return max;
        }
        
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            // if appeared before
            if(hm.containsKey(s.charAt(i))){
                // update max
                max = Math.max(max,curCount);
                // find out which index to start the new count
                newStart = Math.max(hm.get(s.charAt(i))+1, newStart);
                // update curCount based on newStart
                curCount = i - newStart+1;
            }
            // if new character
            else{
                curCount++;
            }
            hm.put(s.charAt(i),i);
        }
        return Math.max(max,curCount);
    }
}
