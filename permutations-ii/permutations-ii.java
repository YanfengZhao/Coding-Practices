/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

// Very similar to permutation-i. Backtracking recursion.
// First modification has been made is passing into recursive function a visited list. 
// This avoids adding in values that belong to indexes that has already been added.
// This modification isn't enough because TLE can occur.
// So the second modification and the key is to first sort the array.
// In the recursive method, if the index is not visited, also if the previous number in the sorted list is == current number
// in the sorted list, and the previous number has been visited, return. This avoids duplication and more efficient.

public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
    	Arrays.sort(nums);
    	boolean[] visited = new boolean[nums.length];
        helper(nums,new ArrayList<Integer>(),visited);
        return result;
    }
    
    public void helper(int[] nums, ArrayList<Integer> curList, boolean[] visited){
        if(curList.size()==nums.length){
            result.add(new ArrayList<Integer>(curList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
            	if (i > 0 && nums[i] == nums[i-1] && visited[i-1]) {
                    return;
                }
                curList.add(nums[i]);
                visited[i] = true;
                helper(nums,curList,visited);
                curList.remove(curList.size()-1);
                visited[i] = false;
            }
        }
    }
}
