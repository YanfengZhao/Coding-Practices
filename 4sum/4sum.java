/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

// Fix the first 2 numbers, then create a start and an end use the "two pointer method"

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 3; i++){
        	for(int j = i+1; j < nums.length - 2; j++){
        		int start = j+1;
        		int end = nums.length-1;
        		while(start<end){
        			int sum = nums[i]+nums[j]+nums[start]+nums[end];
        			if(sum == target){
        				ArrayList<Integer> temp = new ArrayList<Integer>();
        				temp.add(nums[i]);
        				temp.add(nums[j]);
        				temp.add(nums[start]);
        				temp.add(nums[end]);
        				hs.add(temp);
        				start++;
        			}
        			else if(sum>target){
        				end--;
        			}
        			else{
        				start++;
        			}
        		}
        	}
        }
        return new ArrayList<List<Integer>>(hs);
    }
}
