/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

// Best way to solve this is KMP algorithm, however it is too complicated to implement here.
// Make sure neither are null.
// NOTICE, if the needle size is 0, always return 0.
// Make sure needle length is less than haystack length.
// Traverse every character in the string that is the same as the first character in the needle: 
// if this character index + length of need > length of haystack, return -1,
// else substring and compare to needle, if same return current index.

public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        
        int hlength = haystack.length();
        int nlength = needle.length();
        
        if (nlength == 0){
            return 0;
        }
        
        if(nlength > hlength){
            return -1;
        }
        
        for(int i = 0; i < hlength; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                System.out.println(i+nlength);
                if(i+nlength <= hlength){
                    if(haystack.substring(i,i+nlength).equals(needle)){
                        return i;
                    }
                }
                else{
                    return -1;
                }
            }
        }
        return -1;
    }
}
