/*
You are playing the following Bulls and Cows game with your friend: You write a 4-digit secret number and ask your friend to guess it. Each time your friend guesses a number, you give a hint. The hint tells your friend how many digits are in the correct positions (called "bulls") and how many digits are in the wrong positions (called "cows"). Your friend will use those hints to find out the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
*/

// O(n), one pass.
// If characters match, then add to bulls.
// Else:
// if(arr[s-'0'] < 0) cows++;
// if(arr[g-'0'] > 0) cows++;
// arr[s-'0']++;
// arr[g-'0']--;

public class Solution {
    public String getHint(String secret, String guess) {
        int[] arr = new int[10];
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i < secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g){
                bulls++;
            }
            else{
                if(arr[s-'0'] < 0) cows++;
                if(arr[g-'0'] > 0) cows++;
                arr[s-'0']++;
                arr[g-'0']--;
            }
        }
        
        return bulls+"A"+cows+"B";
    }
}
