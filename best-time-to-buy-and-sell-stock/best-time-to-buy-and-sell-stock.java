/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

// Keep track of the max profit at all times. Initially profit is 0.
// First set min to the first element in prices.
// Traverse every element, calculate and update the max profit.
// If find a smaller element, update min then keep calculating max profit
// O(n) time, O(1) space.

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int profit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            profit = Math.max(profit, prices[i] - min);
        }
        
        return profit;
    }
}
