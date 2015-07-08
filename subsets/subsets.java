/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

// Solution 1 is O(nlogn) using the binary method, O(n) to create the list, but O(nlogn) to sort each subset
// Solution 2 is O(n^2) using the following method:
// Initialy：[]
// After adding S0：[], [S0]
// After adding S1：[], [S0], [S1], [S0, S1]
// After adding S2：[], [S0], [S1], [S0, S1], [S2], [S0, S2], [S1, S2], [S0, S1, S2]

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int size = nums.length;
        if(size == 0){
        	return result;
        }
        int max = 1 << size;
        for (int i = 0; i< max; i++){
        	String b = Integer.toBinaryString(i).toString();
        	StringBuilder sb = new StringBuilder();
        	sb.append(b);
        	while(sb.length()<size){
        		sb.insert(0,'0');
        	}
        	b = sb.toString();
        	ArrayList<Integer> subset = new ArrayList<Integer>();
        	for(int j = b.length()-1; j >= 0; j--){
        		if(b.charAt(j) == '1'){
        			subset.add(nums[j]);
        		}
        	}
        	Collections.sort(subset);
        	result.add(subset);
        }
        return result;
    }
    
    public List<List<Integer>> subsetsS2(int[] nums) {
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
        		result.add(appendedList);
        	}
        }
        return result;
    }
}
