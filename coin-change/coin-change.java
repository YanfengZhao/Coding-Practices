/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.
*/

// Iterative solution.
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] numOfCoins = new int[amount+1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);
        numOfCoins[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int coin : coins){
                if (i >= coin && numOfCoins[i-coin] != Integer.MAX_VALUE){
                    numOfCoins[i] = Math.min(numOfCoins[i-coin] + 1, numOfCoins[i]);
                }
            }
        }
        if (numOfCoins[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return numOfCoins[amount];
    }
}
