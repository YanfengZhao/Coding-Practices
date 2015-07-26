/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

// O(log n) time recursion. Similar to a binary search.
// Compare mid to right, if nums[mid]<nums[right], means the right side is sorted.
// If target is less than mid, then there is no reason to look on the right side.
// If target is greater than mid, then target should be on the right side if it does exist and
// can be searched with simple binary search.

public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        return searchHelper(nums,target,l,r);
    }
    
    public int searchHelper(int[] nums, int target, int l, int r){
        if(l>r){
            return -1;
        }
        int mid = (l+r)/2;
        if(nums[mid] == target){
            return mid;
        }
        int right;
        int left;
        if(nums[mid]<nums[r]){ // if right side is sorted
            if(nums[mid] < target){
                right = searchHelper(nums,target,mid+1,r);
            }
            else{
                right = -1;
            }
        }
        else{ // if not sorted, then need search
            right = searchHelper(nums,target,mid+1,r);
        }
        if(nums[l]<nums[mid]){ // if left side is sorted
            if(nums[mid] > target){
                left = searchHelper(nums,target,l,mid-1);
            }
            else{
                left = -1;
            }
        }
        else{ // if not sorted, then need search
            left = searchHelper(nums,target,l,mid-1);
        }
        return Math.max(left,right);
    }
}
