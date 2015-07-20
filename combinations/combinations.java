/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

// DFS recursion backtracking. For every number i you have added, you have n - i ways to add the next number.
// Base case is when k is 0, which means k numbers have been added to the list.

public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> currList = new ArrayList<Integer>();
        helper(n,k,currList,1);
        return result;
    }
    
    public void helper(int n, int k, ArrayList<Integer> currList, int start){
        if(k == 0){
            result.add(new ArrayList<Integer>(currList));
            return;
        }
        
        for(int i = start; i <= n; i++){
            currList.add(i);
            helper(n,k-1,currList,i+1);
            currList.remove(currList.size()-1);
        }
    }
}
