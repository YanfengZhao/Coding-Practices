/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

// use recursion to this problem by creating a helper recursive method.
// first parameter contains the initial string, second parameter contains the current index, third parameter contains the index trying to reach.
// base case is when index == target.
// save the 0th index and start at 1st index.
// count and add the number of appearances in the string builder. 

public class Solution {
    public String countAndSay(int n) {
        int counter = 0;
        return helper("1",1,n);
    }
    
    public String helper(String w, int index, int target){
        if(index == target){
            return w;
        }
        
        StringBuilder sb = new StringBuilder();
        char prev = w.charAt(0);
        int numOfPrev = 1;
        for(int i = 1; i<w.length(); i++){
            if(w.charAt(i) != prev){
                sb.append(numOfPrev);
                sb.append(prev);
                prev = w.charAt(i);
                numOfPrev = 1;
            }
            else{
                numOfPrev++;
            }
        }
        sb.append(numOfPrev);
        sb.append(prev);
        return helper(sb.toString(), index+1, target);
    }
}
