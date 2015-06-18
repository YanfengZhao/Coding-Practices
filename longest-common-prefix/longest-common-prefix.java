public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            prefix = findCommon(prefix,strs[i]);
        }
        return prefix;
    }
    public String findCommon(String prefix, String s2){
        if(prefix.length() == 0 || s2.length() == 0){
            return "";
        }
        else{
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i != prefix.length() && i != s2.length()){
                if(prefix.charAt(i) == s2.charAt(i)){
                    sb.append(prefix.charAt(i));
                }
                else {
                    break;
                }
                i++;
            }
            return sb.toString();
        }
    }
}
