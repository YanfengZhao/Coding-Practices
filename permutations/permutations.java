/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

// Recursion.
// Keep a list called curList contains what you have already added to the list.
// Once a curList.size() == the nums.length, then a permutation is created, add that to the results.

public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return result;
        }
        ArrayList<Integer> curList = new ArrayList<Integer>();
        helper(nums,curList);
        return result;
    }
    
    public void helper(int[] nums, ArrayList<Integer> curList){
        if(curList.size() == nums.length){
            result.add(new ArrayList<Integer>(curList));
            return;
        }
        
        for(int i : nums){
            if(!curList.contains(i)){
                curList.add(i);
                helper(nums,curList);
                curList.remove(curList.size()-1);
            }
        }
    }
}
