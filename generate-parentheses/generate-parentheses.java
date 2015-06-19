public class Solution {
    public List<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        dfs("",n,n);
        return result;
    }
    
    public void dfs(String s, int left, int right){
        if(left == 0 && right == 0){
            result.add(s);
            return;
        }
        
        if(left == right){
            dfs(s+"(", left-1, right);
        }
        else{
            if(left > 0){
                dfs(s+"(",left-1, right);
            }
            if(right > 0){
                dfs(s+")",left, right-1);
            }
        }
    }
}
