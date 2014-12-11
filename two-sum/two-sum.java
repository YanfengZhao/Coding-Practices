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
