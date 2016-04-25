/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".
*/

// Use 2 pointers start at beginning and end.
// One path.

public class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int p1 = 0;
        int p2 = s.length()-1;
        while(p1<p2){
            if(isVowel(arr[p1]) && isVowel(arr[p2])){
                swap(arr,p1,p2);
                p1++;
                p2--;
            }
            else if(isVowel(arr[p1])){
                p2--;
            }
            else if(isVowel(arr[p2])){
                p1++;
            }
            else{
                p1++;
                p2--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:arr){
            sb.append(c);
        }
        return sb.toString();
    }
    public boolean isVowel(char c){
        if(c == 'a' || c == 'o' || c == 'e' || c == 'u' || c == 'i'
        || c == 'A' || c == 'O' || c == 'E' || c == 'U' || c == 'I'){
            return true;
        }
        return false;
    }
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
