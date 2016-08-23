/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
*/

public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!hm.containsKey(c)){
                hm.put(c, i);
            } else {
                if (hm.get(c) != -1){
                    hm.put(c, -1);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int index : hm.values()){
            if (index != -1){
                min = Math.min(min, index);
            }
        }
        
        if (min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
}
