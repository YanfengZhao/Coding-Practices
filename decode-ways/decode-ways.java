/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

// Similar to the count-way problem where you can walk 1 or 2 steps.
// Use Dynamic Programming bottom up approach.
// First calculate and fill in the number of ways for the first 2 slots in array.
// Then for the rest, it equals number given in the last slot plus the one before that. However only add the number
// in the slot before that if i-1 to i is a valid number (valid(s.substring(i-1,i+1))).

public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0 || s.charAt(0)-'0'==0){
            return 0;
        }
        else if(s.length()==1){
            return 1;
        }
        int[] count = new int[s.length()];

        count[0] = 1;
        if(valid(s.substring(0,2))){
            count[1]++;
        }
        if(s.charAt(1)!='0'){
            count[1]++;
        }
        
        for(int i = 2; i<s.length(); i++){
            if(s.charAt(i)!='0'){
                count[i] += count[i-1];
            }
            if(valid(s.substring(i-1,i+1))){
                count[i] += count[i-2];
            }
        }
        return count[s.length()-1];
    }
    
    // this method checks if this given number has a valid mapping to a single character 
    public boolean valid(String str){
        return str.charAt(0) != '0' && Integer.valueOf(str)>0 && Integer.valueOf(str)<=26; 
    }
}
