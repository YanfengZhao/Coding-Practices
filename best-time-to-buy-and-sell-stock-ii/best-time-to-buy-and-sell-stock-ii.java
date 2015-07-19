/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

// Greedy Algorthm. O(n) time. 
// Compare current to next, if less than next, add the difference to profit.

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length == 0){
            return profit;
        }

        for(int i = 0; i < prices.length-1; i++){
            if(prices[i+1] > prices[i]){
                profit += prices[i+1] - prices[i];
            }
        }
        
        return profit;
    }
}
