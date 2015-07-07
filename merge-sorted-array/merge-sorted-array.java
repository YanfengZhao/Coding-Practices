/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

// O(n). Append from back of the array forward

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int startIndex = n+m-1;
        int mIndex = m - 1;
        int nIndex = n - 1;
        for(int i = startIndex; i>=0; i--){
            if(mIndex == -1){
                nums1[i]=nums2[nIndex];
                nIndex--;
            }
            else if(nIndex == -1){
                nums1[i]=nums1[mIndex];
                mIndex--;
            }
            else if(nums1[mIndex]>nums2[nIndex]){
                nums1[i]=nums1[mIndex];
                mIndex--;
            }
            else{
                nums1[i]=nums2[nIndex];
                nIndex--;
            }
        }
    }
}
