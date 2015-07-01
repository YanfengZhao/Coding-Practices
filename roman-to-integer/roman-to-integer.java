/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

// First put all symbols and their corresponding values in a HashMap.
// For every character, if the character is not the last character and less than the next character, subtract.
// All other characters, add to the total sum.

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum=0;
        
        for(int i = 0;i < s.length();i++){
            // if not last character and less than then next character, subtract
            // all other character add
            if(i!=s.length()-1 && map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                sum -= map.get(s.charAt(i));
            }else{
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
}
