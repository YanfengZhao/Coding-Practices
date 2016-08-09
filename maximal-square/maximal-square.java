/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/

// Preprocess the matrix to copy top row and left column into 2-D dp array.
// If 1 is seen, remember it.
// To calculate dp[i][j]:
// If matrix[i][j] == '0', then dp[i][j] = 0.
// If matrix[i][j] == '1', then dp[i][j] = min(dp left, dp above, dp above left) + 1.
// Update the max with each calculation.
// Remember to square the max to get the area. 
// If area is 0, and atLeast1 is seen, then return 1.

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        // preprocess
        int[][] dp = new int[matrix.length][matrix[0].length];
        int atLeast1 = 0;
        for (int i = 0; i < matrix.length; i++){
            dp[i][0] = matrix[i][0] - '0';
            if(dp[i][0] == 1) atLeast1 = 1;
        }
        for (int i = 0; i < matrix[0].length; i++){
            dp[0][i] = matrix[0][i] - '0';
            if(dp[0][i] == 1) atLeast1 = 1;
        }
        
        int max = 0;
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return Math.max(max * max, atLeast1);
    }
}
