/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

// Solution 1
// Iterative way of solving this problem, best solution. Easier than recursion.

public class Solution {
    public int climbStairs(int n) {
        if (n == 0){
            return 1;
        }
        int[] steps = new int[n+1];
        steps[0] = 1;
        steps[1] = 1;
        for(int i = 2; i < n+1; i++){
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];
    }
}

// Solution 2
// Have to think about all permutations, walking 1 step then 2 steps is different from walking 2 steps then 1 step.
// Use the helper recursive method to pass in parameter such as dp array, for dynamic programming.
// Each index in the dp array stores the number of ways it can get to that step.
// Like all the dynamic programming problems, this is a bottom-up approach.
// The # of ways to get to this step = the # of ways to get to the last step + the # of ways to get to the step before that.

public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return climbStairsHelper(n,dp);
    }
    
    public int climbStairsHelper(int n, int[] dp){
        if(n==0){
            return 1;
        }
        else if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        else if(dp[n] > 0){
            return dp[n];
        }
        else{
            dp[n] = climbStairsHelper(n-1,dp)+climbStairsHelper(n-2,dp);
            return dp[n];
        }
    }
}
