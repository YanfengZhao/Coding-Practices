/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]
*/

// This solution works but exceeds time limit.
// Finds all possible combinations and check if each of them is valid.
// If valid and size is greater than current result, update the current result.

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        getCombinations(combinations, nums, 0, new ArrayList<Integer>());
        for (List<Integer> list : combinations){
            if (checkValid(list) && list.size() > result.size()){
                result = list;
            }
        }
        return result;
    }
    
    public void getCombinations(List<List<Integer>> combinations, int[] nums, int index, List<Integer> cur){
        if (index == nums.length){
            combinations.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = index; i < nums.length; i++){
            cur.add(nums[i]);
            getCombinations(combinations, nums, i + 1, cur);
            cur.remove(cur.size()-1);
        }
    }
    
    public boolean checkValid(List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                if(!(list.get(i)%list.get(j)==0 || list.get(j)%list.get(i)==0)){
                    return false;
                }
            }
        }
        return true;
    }
}
