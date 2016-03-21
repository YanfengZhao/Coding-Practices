/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
Hint:

You should make use of what you have produced already.
Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
Or does the odd/even status of the number help you in calculating the number of 1s?
*/

// O(N) one pass DP solution.
// Keep track of the what power you are at, for example, 2^1,2^2, etc.
// Keep track of the index.
// If the number is odd, simply add 1 to the previous element in the array.
// If the number is even, first check if it is a power of 2.
// If it is a power of 2, increment power, reset index, and set curr loc in arr to 1.
// If it's not a power of 2, increment the index and arr[i] = 1+arr[index]

public class Solution {
    public int[] countBits(int num) {
        if(num == 0){
            return new int[]{0};
        }
        
        int[] arr = new int[num+1];
        arr[0] = 0;
        int power = 1;
        int index = 1;
        for(int i = 1; i<arr.length; i++){
            // if odd, simple add 1 to prev
            if(i%2 == 1){
                arr[i] = arr[i-1]+1;
            }
            else{
                if(i == Math.pow(2,power)){
                    arr[i] = 1;
                    power++;
                    index = 0;
                }
                else{
                    index++;
                    arr[i] = 1+arr[index];
                }
            }
        }
        return arr;
    }
}
