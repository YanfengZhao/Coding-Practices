/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

// O (n log n)
// Create a DP array to store a list of number.
// Create a variable pos to keep track of the position of the last element in array.
// Traverse the input array and 2 cases come up:
// 1. If num > last number in DP, append the num to the end of DP
// 2. If num <= last number in DP, call binary search and replace the number found with the given num.
// The binary search returns the index of a number that is the first number that's greater than given num,
// Return pos + 1.

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int pos = 0;
        dp[pos] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > dp[pos]){
                pos++;
                dp[pos] = nums[i];
            }
            else{
                int indexOfLastBiggerNum = binarySearch(dp, pos, nums[i]);
                dp[indexOfLastBiggerNum] = nums[i];
            }
        }
        return pos+1;
    }
    
    public int binarySearch(int[] dp, int pos, int num){
        int l = 0;
        int r = pos;
        int mid = 0;
        while(l+1<r){
            mid = (l+r)/2;
            if (dp[mid] == num){
                return mid;
            }
            else if (dp[mid] > num){
                r = mid;
            }
            else if (dp[mid] < num){
                l = mid;
            }
        }
        if (dp[r] < num) return pos+1;
        else if (dp[l] >= num) return l;
        else return r;
    }
}
