/*
Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
*/

// use hashmap key as the number, value as the index where it last appears.

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i]) && Math.abs(i-hm.get(nums[i]))<=k){ // contains the key and calculated distance is <= k
                return true;
            }
            hm.put(nums[i],i);
        }
        return false;
    }
}
