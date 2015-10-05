/*
Given a pattern and a string str, find if str follows the same pattern.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
Both pattern and str contains only lowercase alphabetical letters.
Both pattern and str do not have leading or trailing spaces.
Each word in str is separated by a single space.
Each letter in pattern must map to a word with length that is at least 1.
*/

// Beware of the case:
// "abba" with str = "dog dog dog dog".
// Create 2 hashmaps, one is character to string, the other is string to character.

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> hm = new HashMap<Character,String>();
        HashMap<String,Character> hm2 = new HashMap<String,Character>();
        String[] sArr = str.split(" ");
        if(sArr.length!=pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(hm.containsKey(c)){
                if(!hm.get(c).equals(sArr[i])){
                    return false;
                }
            }
            else if(hm2.containsKey(sArr[i])){
                if(hm2.get(sArr[i])!=c){
                    return false;
                }
            }
            else{
                hm.put(c,sArr[i]);
                hm2.put(sArr[i],c);
            }
        }
        return true;
    }
}
