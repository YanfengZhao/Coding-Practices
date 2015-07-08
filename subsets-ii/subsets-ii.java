/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

// very similar to the other subsets question, just have to check for duplicates before adding to result

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int size = nums.length;
        if(size == 0){
        	return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        result.add(list);
        for(int i : nums){
        	int resultSize = result.size();
        	for(int j = 0; j < resultSize; j++){
        		ArrayList<Integer> appendedList = new ArrayList<Integer>(result.get(j));
        		appendedList.add(i);
        		Collections.sort(appendedList);
        		if(!result.contains(appendedList)){
        		    result.add(appendedList);
        		}
        	}
        }
        return result;
    }
}
