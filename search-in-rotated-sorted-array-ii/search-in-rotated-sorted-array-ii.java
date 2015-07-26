/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

// O(log n) time recursion. Worst case O(n). Similar to a binary search.
// Compare mid to right, if nums[mid]<nums[right], means the right side is sorted.
// If target is less than mid, then there is no reason to look on the right side.
// If target is greater than mid, then target should be on the right side if it does exist and
// can be searched with simple binary search.

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0){
            return false;
        }
        int l = 0;
        int r = nums.length-1;
        return searchHelper(nums,target,l,r);
    }
    
    public boolean searchHelper(int[] nums, int target, int l, int r){
        if(l>r){
            return false;
        }
        int mid = (l+r)/2;
        if(nums[mid] == target){
            return true;
        }
        boolean right;
        boolean left;
        
        if(nums[mid]<nums[r]){ // if right side is sorted
            if(nums[mid] <= target){
                right = searchHelper(nums,target,mid+1,r);
            }
            else{
                right = false;
            }
        }
        else{ // if not sorted, then need search
            right = searchHelper(nums,target,mid+1,r);
        }
        
        if(nums[l]<nums[mid]){ // if left side is sorted
            if(nums[mid] >= target){
                left = searchHelper(nums,target,l,mid-1);
            }
            else{
                left = false;
            }
        }
        else{ // if not sorted, then need search
            left = searchHelper(nums,target,l,mid-1);
        }
        System.out.println(nums[mid]);
        return left||right;
    }
}
