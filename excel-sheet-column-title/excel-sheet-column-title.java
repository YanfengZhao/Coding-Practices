/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
*/

// Convert number to corresponding letter:
// (char)(mod+'A'))
// BE CAREFUL, if mod == 0, then it is calculated as Z. By decrementing n solves the problem!!!

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            n--;
            int mod = n%26;
            n/=26;
            
            sb.insert(0, (char)(mod+'A'));
        }
        return sb.toString();
    }
}
