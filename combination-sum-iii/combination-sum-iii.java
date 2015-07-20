/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

// DFS recursion. 
// Keep track of k and n. Everytime call helper method, decrease k by 1 and decrease n by the current value added to currList.
// Base case is when k and n both == 0. Or when k is 0 but n is not 0.

public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k == 0 || n < 1){
            return new ArrayList<List<Integer>>(result);
        }
        ArrayList<Integer> currList = new ArrayList<Integer>();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        helper(k,n,nums,currList,0);
        return result;
    }
    
    public void helper(int k, int n, int[] nums, ArrayList<Integer> currList, int start){
    	if(k==0 && n==0){
            result.add(new ArrayList<Integer>(currList));
            return;
        }
        if(k==0 && n!=0){
            return;
        }
        for(int i = start; i < nums.length; i++){
        	if(n-nums[i] >= 0 ){
	            currList.add(nums[i]);
	            helper(k-1,n-nums[i],nums,currList,i+1);
	            currList.remove(currList.size()-1);
        	}
        }
    }
}
