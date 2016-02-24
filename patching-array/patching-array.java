/*
Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
nums = [1, 5, 10], n = 20
Return 2.
The two patches can be [2, 4].

Example 3:
nums = [1, 2, 2], n = 5
Return 0.
*/

// Solution 2. This solution does not pass Leetcode due to memory limit exceeded
// as well as the array created is greater than maximum size array allowed in Java.
// However this solution works if there is no memory limit.

public class Solution {
    public int minPatches(int[] nums, int n) {
        // numbers that have been covered
        boolean[] covered = new boolean[n+1];
        
        int patch = 0;
        int numsLength = nums.length;
        
        // Step 1, create a permutation sum for given numbers
        int possible = (int)Math.pow(2.0,(double)numsLength)-1;
        for(int i = 1; i <= possible; i++){
            
            String choice = Integer.toBinaryString(i);
            
            char[] cArr = choice.toCharArray();
            int sum = 0;
            int index = nums.length-1;
            for(int j = cArr.length-1; j>=0; j--){
                if(cArr[j] == '1'){
                    sum+=nums[index];
                }
                index--;
            }
            covered[sum] = true;
        }
        
        // Step 2, traverse the covered array, once find an uncovered number,
        // cover it. For every number that's already covered, add
        // this number to that and cover it as well.
        for(int i = 1; i < covered.length; i++){
            if(covered[i] == false){
                boolean[] tmp = covered;
                for(int j = 1; j < covered.length; j++){
                    if(tmp[j] && j+i<covered.length){
                        covered[j+i] = true;
                    }
                }
                // Increment patch count every time a new current number is covered
                patch++;
                covered[i] = true;
            }
        }

        return patch;
    }
}
