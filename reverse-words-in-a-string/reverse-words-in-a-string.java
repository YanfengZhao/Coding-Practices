/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/

// first split the string by spaces.
// create a StringBuffer, append words in backwards.
// REMEMBER check before you append, make sure you are not adding empty strings to the result

public class Solution {
    public String reverseWords(String s) {
        String[] sarr = s.split(" ");
        StringBuffer sbuf = new StringBuffer();
        for(int i = sarr.length-1; i>=0;i--){
            if(!sarr[i].equals("")){
                sbuf.append(sarr[i]+" ");
            }
        }
        if(sbuf.length()!=0)
            sbuf.deleteCharAt(sbuf.length()-1);
        return sbuf.toString();
    }
}
