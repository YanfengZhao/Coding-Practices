public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0 || s.charAt(0)-'0'==0){
            return 0;
        }
        else if(s.length()==1){
            return 1;
        }
        int[] count = new int[s.length()];

        count[0] = 1;
        if(valid(s.substring(0,2))){
            count[1]++;
        }
        if(s.charAt(1)!='0'){
            count[1]++;
        }
        
        for(int i = 2; i<s.length(); i++){
            if(s.charAt(i)!='0'){
                count[i] += count[i-1];
            }
            if(valid(s.substring(i-1,i+1))){
                count[i] += count[i-2];
            }
        }
        return count[s.length()-1];
    }
    
    public boolean valid(String str){
        return str.charAt(0) != '0' && Integer.valueOf(str)>0 && Integer.valueOf(str)<=26; 
    }
}
