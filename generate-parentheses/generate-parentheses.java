/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

// Use recursion to solve this problem.
// Keep track of number of left parenthesis and number of right parenthesis and the string of parenthesis being built.
// base case is both left and right parenthesis are equal to 0. Which means you have generated a valid permutation of parenthesis.
// if base case is not true, check if left == right, if true, then you can only add left parenthesis to string and call dfs.
// else if not equal, you know right CANNOT be greater than left at anytime,
// so if left > 0 , add left to string,
// also if right > 0, you can add right to string.

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
