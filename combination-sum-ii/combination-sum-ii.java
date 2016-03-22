/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

// DFS backtracking recursion. Similar to combination-sum-i. 
// Only difference is in this case, everytime you call the helper in the helper method, 
// you need to increment the start index by 1 and pass it as the index parameter.
// necessary to use set: [1,1] 1 -> [[1] , [1]] but actually we only want one [1].

public class Solution {
    Set<List<Integer>> result = new HashSet<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0){
            return new ArrayList<List<Integer>>(result);
        }
        Arrays.sort(candidates);
        ArrayList<Integer> currList = new ArrayList<Integer>();
        helper(candidates, target, 0, currList);
        return new ArrayList<List<Integer>>(result);
    }
    
    public void helper(int[] candidates, int target, int start, ArrayList<Integer> currList){
        if(target == 0){
            result.add(new ArrayList<Integer>(currList));
            return;
        }
        
        for(int i = start; i < candidates.length; i++){
            if(target - candidates[i] >= 0){
                currList.add(candidates[i]);
                helper(candidates, target - candidates[i], i+1, currList);
                currList.remove(currList.size()-1);
            }
        }
    }
}

// Second solution, without any loops. A little slower than first version due to
// more recursive calls.

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(candidates);
        ArrayList<Integer> curList = new ArrayList<Integer>();
        helper(result,candidates,target,0,curList);
        return new ArrayList<List<Integer>>(result);
    }
    public void helper(Set<List<Integer>> result, int[] candidates, int target, int i, ArrayList<Integer> curList){
        if(i>candidates.length-1 || target < 0){
            return;
        }
        if(target == candidates[i]){
            curList.add(candidates[i]);
            result.add(new ArrayList<Integer>(curList));
            curList.remove(curList.size()-1);
            return;
        }
       
        helper(result, candidates, target, i+1, curList);
        curList.add(candidates[i]);
        helper(result, candidates, target-candidates[i], i+1, curList);
        curList.remove(curList.size()-1);
    }
}
