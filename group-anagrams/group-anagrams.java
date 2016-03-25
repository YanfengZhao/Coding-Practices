/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/

// The important aspect to this problem is that you cannot treat this as a regular anagram problem.
// When you are simply checking if 2 strings are anagram of each other, it's O(n) where n is length of the longer string.
// However this problem you have to sort the strings' characters and use them as a key to the map and value is 
// a corresponding list of words that contains those characters.
// The time complexity is 
// O(number of words) * O(nlogn)

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String,ArrayList<String>> hm = new HashMap<String,ArrayList<String>>();
        for(String s:strs){
            char[] cArr = s.toCharArray();
            Arrays.sort(cArr);
            
            String strVal = String.valueOf(cArr); // get the string representation of the character array
            if(hm.containsKey(strVal)){
                ArrayList<String> list = hm.get(strVal);
                list.add(s);
                hm.put(strVal,list);
            }
            else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(s);
                hm.put(strVal,list);
            }
        }
        
        for(List<String> list:hm.values()){
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}
