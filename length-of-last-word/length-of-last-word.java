public class Solution {
    public int lengthOfLastWord(String s) {
        String trimed = s.trim();
        if (trimed.length() == 0){
            return 0;
        }
        int counter = 0;
        for(int i = trimed.length()-1; i>=0; i--){
            if(trimed.charAt(i) == ' '){
                break;
            }
            else{
                counter++;
            }
        }
        return counter;
    }
}
