/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

// the key here is to determine whether words are anagrams by sorting their characters and storing in hashmap.
// if the hashmap already contain it, then the word is anagram with the one in the hashmap.
// also don't forget to add the one that's first added into the hashmap to the result once and only once.
// you can make sure of this by setting its value to string "0" if it has already been added to the result.

public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        HashMap<String,String> hm = new HashMap<String,String>();
        for(String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(hm.containsKey(sorted)){
                result.add(s);
                if(!hm.get(sorted).equals("0")){
                    result.add(hm.get(sorted));
                    hm.put(sorted,"0");
                }
            }
            else{
                hm.put(sorted,s);
            }
        }
        return result;
    }
}
