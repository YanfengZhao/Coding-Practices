/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

// create a HashMap, key is the number, value is the index of where the number appears in the array.
// for every number, check if the complement of current number is in the map,
// if yes, solution is found
// else, store the number in the hashmap with its index

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int index = 0; index < numbers.length; index++){
            if(hash.containsKey(target-numbers[index])){
                result[0]= hash.get(target-numbers[index]);
                result[1]= index+1;
                return result;
            }
            hash.put(numbers[index],index+1);
        }
        return result;
    }
}
