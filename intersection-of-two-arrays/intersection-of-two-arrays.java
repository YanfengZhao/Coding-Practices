/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

// Store everything in nums2 in a hashset.
// Traverse nums1 see if that set contains any of the numbers.
// If so, add to the intersection hashset.
// Return an array very of the intersection hashset.

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<Integer>();
        HashSet<Integer> nums2set = new HashSet<Integer>();
        for(int i : nums2){
            nums2set.add(i);
        }
        for(int i: nums1){
            if(nums2set.contains(i)){
                hs.add(i);
            }
        }
        int[] result = new int[hs.size()];
        int index = 0;
        for(Integer i:hs){
            result[index] = i;
            index++;
        }
        return result;
    }
}
