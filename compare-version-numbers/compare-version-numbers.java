/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/

public class Solution {
    public int compareVersion(String version1, String version2) {
    
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        // if . doesn't exist, replace with 0
        for (int i = 0; i < Math.max(v1.length, v2.length); i++){
            int x;
            if(i<v1.length){
                x = Integer.parseInt(v1[i]);
            }
            else{
                x = 0;
            }
            int y;
            if(i<v2.length){
                y = Integer.parseInt(v2[i]);
            }
            else{
                y = 0;
            }
            
            if(x<y){
                return -1;
            }
            else if(x>y){
                return 1;
            }
        }
        return 0;
    }
}
