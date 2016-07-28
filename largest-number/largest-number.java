/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

// Store all integers into an array of Strings.
// Sort the array of Strings with a customized sorter: Arrays.sort(arr, new Comp());
// Implement the customized sorter's compare() method. 
// Compare character to character. If the size of 2 strings are different,
// call compare to recursively with the parameter in the same order but with the short string and
// the substring of the latter part of the longer string.
// Lastly make sure the string we are returning does not lead with 0.

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return "";
        }
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            arr[i] = nums[i] + "";
        }
        Arrays.sort(arr, new Comp());
        StringBuilder sb = new StringBuilder();
        for (String s : arr){
            if(sb.length() == 0 && s.startsWith("0"))
		        continue;
            sb.append(s);
        }
        String result = sb.toString();
        if (result.length() == 0) return "0";
        return result;
    }
    
    public class Comp implements Comparator<String>{
        
        public int compare(String s1, String s2){
            int s1Len = s1.length();
            int s2Len = s2.length();
            int shorterLen = Math.min(s1Len, s2Len);
            for (int i = 0; i < shorterLen; i++){
                char s1c = s1.charAt(i);
                char s2c = s2.charAt(i);
                if (s1c > s2c) return -1;
                else if (s1c < s2c) return 1;
            }
            if (s1Len != s2Len){
                if (s1Len > s2Len){
                    return compare(s1.substring(shorterLen, s1Len), s2);
                } else {
                    return compare(s1, s2.substring(shorterLen, s2Len));
                }
            }
            return 0;
        }
    }
}
