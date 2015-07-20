/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3]
*/

// DFS recursion backtracking.
// keep a current list. Every time decrease the target until target reaches 0 or less than 0.
public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        ArrayList<Integer> currList = new ArrayList<Integer>();
        if(candidates.length == 0){
            return result;
        }
        // sorting the candidates improves efficiency so in helper function don't have to try to add every candidate
        Arrays.sort(candidates); 
        
        helper(candidates, currList, target, 0);
        return result;
    }
    
    public void helper(int[] candidates, ArrayList<Integer> currList, int target, int start){
        if(target == 0){
            result.add(new ArrayList<Integer>(currList));
            return;
        }
        else{
            for(int i = start; i < candidates.length; i++){
                if(target-candidates[i] < 0){
                    break;
                }
                else{
                    currList.add(candidates[i]);
                    helper(candidates,currList,target-candidates[i], i);
                    currList.remove(currList.size()-1);
                }
            }
        }
    }
}
