/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
*/

// uses hashmap, key is the character in s, value is its corresponding character in t.

public class Solution {
    public boolean isIsomorphic(String s, String t){
        HashMap<Character,Character> hm = new HashMap<Character,Character>();
        if(s==null || t== null || s.length()!=t.length()){
            return false;
        }

        // traverse string s and t
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            
            if(hm.containsKey(a)){
                if(hm.get(a) == (b)){
                    continue;
                }
                else{
                    return false;
                }
            }
            else{
                if(!hm.containsValue(b)){
                    hm.put(a,b);
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }
}
