/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

// Add all numbers into HashSet.
// Traverse every number in the ARRAY, notice to traverse array rather than HashSet.
// If HashSet contains the number, look left and look right for all consecutive numbers and add to count.
// Delete the numbers from the HashSet while looking, and delete the number itself.
// Lastly compare to result and take the max.

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int result = 0;
        
        // add all nums to HashSet
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int n:nums){
            hs.add(n);
        }
        
        // traverse HashSet
        for(int i = 0; i < nums.length;i++){
            int count = 1;
            int temp = nums[i];
            // look right while removing and incrementing count
            while(hs.contains(++temp)){
                hs.remove(temp);
                count++;
            }
            temp = nums[i];
            // look left while removing and incrementing count
            while(hs.contains(--temp)){
                hs.remove(temp);
                count++;
            }
            // remove itself from HashSet
            hs.remove(nums[i]);
            result = Math.max(count,result);
        }
        
        return result;
    }
}
