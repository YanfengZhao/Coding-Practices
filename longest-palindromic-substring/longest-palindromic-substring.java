/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

// The key to this problem is adding the '#' between each character. 
// This way removes the corner cases of having an odd vs even palindrome.
// Then for every character in the string, expand until its palindromic nature becomes invalid 
// while keeping track of the longest palindrome and its middle index.
// Finally use Stringbuilder to build the recorded max palindrome

public class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0)
            return "";
        
        // add # in between each character
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        
        String prePro = sb.toString();
        
        int max = 0;
        int index = 0;
        
        // for every character in the list, expand
        for (int i = 0; i < prePro.length(); i++){
            int l = i - 1;
            int r = i + 1;
            int temp = 0;
            while(l>=0 && r<=prePro.length()-1){
                if(prePro.charAt(l)==prePro.charAt(r)){
                    temp++;
                }
                else{
                    break;
                }
                l--;
                r++;
            }
            if(max < temp){
                max = temp;
                index = i;
            }
        }
        
        // find the pal string
        StringBuilder result = new StringBuilder();
        for(int i = index - max+1; i <= index + max; i = i+2){
            result.append(prePro.charAt(i));
        }
        return result.toString();
    }
}
