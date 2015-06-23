public class Solution {
    public String countAndSay(int n) {
        int counter = 0;
        return helper("1",1,n);
    }
    
    public String helper(String w, int index, int target){
        if(index == target){
            return w;
        }
        
        StringBuilder sb = new StringBuilder();
        char prev = w.charAt(0);
        int numOfPrev = 1;
        for(int i = 1; i<w.length(); i++){
            if(w.charAt(i) != prev){
                sb.append(numOfPrev);
                sb.append(prev);
                prev = w.charAt(i);
                numOfPrev = 1;
            }
            else{
                numOfPrev++;
            }
        }
        sb.append(numOfPrev);
        sb.append(prev);
        return helper(sb.toString(), index+1, target);
    }
}
