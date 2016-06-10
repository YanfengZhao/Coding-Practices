/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
*/

// N^2 where N is number of words.
// Have 2 nested for loops.
// First is N*M where M is number of characters in the word.
// For each word, calculate their int representation of the word and store in a separate array (bit manipulation).
// Second is N*N, where you compare 2 words at the same time and calculate max.

public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0){
            return 0;
        }
        int len = words.length;
        int[] value = new int[words.length];
        
        for (int i = 0; i < words.length; i++){
            value[i] = 0;
            for (char c : words[i].toCharArray()){
                value[i] |= 1 << (c-'a');
            }
        }
        
        int max = 0;
        for (int i = 0; i < words.length; i++){
            for (int j = i+1; j < words.length; j++){
                if((value[i] & value[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
