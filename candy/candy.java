/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/

// 4 pass. Really just 2 pass, one pass start from left to right, second pass from right to left.
// First create a new array same size as rating called candies, initialize all to be 1.
// (1) start at index 1, if ratings[i]>ratings[i-1], candies[i] = candies[i-1]+1.
// (2) start at the end of candies array, if ratings[i] < ratings[i-1] && candies[i-1]<=candies[i],
// then candies[i-1] = candies[i]+1.
// In the end add up all values in candies.

public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        // initialize everything in candies as 1
        for(int i = 0; i < candies.length; i++){
            candies[i] = 1;
        }
        
        // start from the left, if current is greater than previous, current = previous + 1
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        
        // start from the right side
        for(int i = ratings.length-1; i>=1; i--){
            if(ratings[i] < ratings[i-1] && candies[i-1]<=candies[i]){
                candies[i-1] = candies[i]+1;
            }
        }
        
        int sum = 0;
        for(int i:candies){
            sum+=i;
        }
        return sum;
    }
}
