/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

// First solution we use the iterative method

public class Solution {
    public String countAndSay(int n) {
        if(n < 1){
            return "";
        }

        String result = "1";
        for(int i = n; i >= 2; i--){
            char[] arr = result.toCharArray();
            
            StringBuilder sb = new StringBuilder();
            int counter = 1;
            for(int j = 0; j < arr.length; j++){
                // if is last element
                if(j == arr.length-1){
                    sb.append(counter);
                    sb.append(arr[j]);
                }
                // if not equal to next element
                else if(arr[j] != arr[j+1]){
                    sb.append(counter);
                    sb.append(arr[j]);
                    counter = 1;
                }
                // if equal to next element
                else{
                    counter++;
                }
            }

            result = sb.toString();
        }
        
        return result;
    }
}

// Second solution we use recursion to this problem by creating a helper recursive method.
// First parameter contains the initial string, second parameter contains the current index, third parameter contains the index trying to reach.
// Base case is when index == target.
// Save the 0th index and start at 1st index.
// Count and add the number of appearances in the string builder. 

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
