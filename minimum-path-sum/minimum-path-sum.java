/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

// DP O(n^2)
public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] min = new int[grid.length][grid[0].length];
        
        // preprocess the top and left edge
        min[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++){
            min[i][0] = grid[i][0]+min[i-1][0];
        }
        for(int i = 1; i < grid[0].length; i++){
            min[0][i] = grid[0][i] + min[0][i-1];
        }
        
        // populate rest of the min
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                min[i][j] = Math.min(min[i-1][j], min[i][j-1])+grid[i][j];
            }
        }
        
        return min[grid.length-1][grid[0].length-1];
    }
}
