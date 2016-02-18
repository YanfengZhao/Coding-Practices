/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
*/

// Allocate 2 variables set them to max int.
// If a number is smaller than small, then we need to reset the small so it is the smallest.
// If a number is bigger than small, but however less than large, we set it as new large (The large means the mid number).
// If a number is greater than both small and large, we know we found our solution.
// small... larget ... largest

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length<3) return false;
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        
        for(int n: nums){
            if(n <= small){ // if smaller than the current small, need to reset small with current n
                small = n;
            }
            else if(n <= big){ // if less than be, then this can be the new big
                big = n;
            }
            else{ // if greater than both, then must be true
                return true;
            }
        }
        return false;
    }
}
