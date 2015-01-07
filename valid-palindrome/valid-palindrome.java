public class Solution {
    public boolean isPalindrome(String s) {
        String lowercase = s.toLowerCase();
        StringBuffer strBuf = new StringBuffer();
        for(int i = 0; i < lowercase.length() ; i++){
            if((lowercase.charAt(i)>='a' && lowercase.charAt(i)<='z' )|| (lowercase.charAt(i)>='0' && lowercase.charAt(i)<='9')){
                strBuf.append(lowercase.charAt(i));
            }
        }
        if(strBuf.toString().equals(strBuf.reverse().toString())) return true;
        else return false;
    }
}
