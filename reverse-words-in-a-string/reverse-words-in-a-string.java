public class Solution {
    public String reverseWords(String s) {
        String[] sarr = s.split(" ");
        StringBuffer sbuf = new StringBuffer();
        for(int i = sarr.length-1; i>=0;i--){
            if(!sarr[i].equals("")){
                sbuf.append(sarr[i]+" ");
            }
        }
        if(sbuf.length()!=0)
            sbuf.deleteCharAt(sbuf.length()-1);
        return sbuf.toString();
    }
}
