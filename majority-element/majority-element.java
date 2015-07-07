/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

// Solution 1: O(n) time, O(1) Space.
// if we cancel out each occurrence of an element e with all the other elements
// that are different from e then e will exist till end if it is a majority element.

// Solution 2: Sort and return the element in the middle of the list. O(nlogn).

public class Solution {
    public int majorityElement(int[] nums) {
       int count=0;
       int majority = nums[0];
       for(int n:nums){
    	   if(count == 0){
    		   count++;
    		   majority = n;
    	   }
    	   else if(n == majority){
    		   count++;
    	   }
    	   else{
    		   count--;
    	   }
       }
       return majority;
    }

    public int majorityElementS2(int[] num) {
        Arrays.sort(num);
        return num[num.length/2];
    }
}
