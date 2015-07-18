/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
*/

// It is possible to have 2 majority elements.
// See majority-element-i.
// O(n) time, O(1) space.
// Set up 2 counters for each of those elements.
// Go through the list twice.
// First loop collect the 2 element that could be the majority elements.
// Second loop verifies if they are majority elements.
// Before adding to the list, make sure same numbers won't be added twice.

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums.length == 0){
            return result;
        }
        if(nums.length == 1){
            result.add(nums[0]);
            return result;
        }
        int count1 = 0;
        int count2 = 0;
        int choice1 = 0;
        int choice2 = 1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == nums[choice1]){
                count1++;
            }
            else if(nums[i] == nums[choice2]){
                count2++;
            }
            else if(count1 == 0){
                count1++;
                choice1 = i;
            }
            else if(count2 == 0){
                count2++;
                choice2 = i;
            }
            else{
                count1--;
                count2--;
            }
        }
        
        // go through the list the second time if the 2 numbers collected are indeed majority.
        count1=0;
        count2=0;
        for(int i: nums){
            if(i==nums[choice1]){
                count1++;
            }
            if(i==nums[choice2]){
                count2++;
            }
        }
        if(count1>nums.length/3){
            result.add(nums[choice1]);
        }
        if(count2>nums.length/3 && nums[choice2]!=nums[choice1]){ // make sure the same number won't be added twice
            result.add(nums[choice2]);
        }
        return result;
    }
}
