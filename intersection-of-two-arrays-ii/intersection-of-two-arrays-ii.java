/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to num2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

// Use Hashmap to keep track of occurances of every element in nums2.

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer,Integer> nums2map = new HashMap<Integer,Integer>();
        for(int i : nums2){
            if(nums2map.containsKey(i)){
                nums2map.put(i,nums2map.get(i)+1);
            }
            else{
                nums2map.put(i,1);
            }
        }
        for(int i: nums1){
            if(nums2map.containsKey(i) && nums2map.get(i)>0){
                list.add(i);
                nums2map.put(i,nums2map.get(i)-1);
            }
        }
        int[] result = new int[list.size()];
        int index = 0;
        for(Integer i:list){
            result[index] = i;
            index++;
        }
        return result;
    }
}
