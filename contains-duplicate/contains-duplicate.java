/*
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*/

// be careful return true if duplicate, false if there is no duplicate

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length==0){
            return false;
        }
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int n : nums){
            if(hs.contains(n)){
                return true;
            }
            else{
                hs.add(n);
            }
        }
        return false;
    }
}
