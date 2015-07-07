/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

// fix the first number, then create start and end use 2-pointer method

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        Arrays.sort(nums);
        
        for(int i = 0; i <= nums.length - 3; i++){
    		int start = i+1;
    		int end = nums.length-1;
    		while(start<end){
    			int sum = nums[i]+nums[start]+nums[end];
    			if(sum == 0){
    				ArrayList<Integer> temp = new ArrayList<Integer>();
    				temp.add(nums[i]);
    				temp.add(nums[start]);
    				temp.add(nums[end]);
    				hs.add(temp);
    				start++;
    				end--;
    			}
    			else if(sum>0){
    				end--;
    			}
    			else{
    				start++;
    			}
        	}
        }
        return new ArrayList<List<Integer>>(hs);
    }
}


