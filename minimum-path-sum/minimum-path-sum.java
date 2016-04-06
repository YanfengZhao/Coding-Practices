/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

// DP O(n^2)
// Modify original array without creating new space.

public class Solution {
    public int minPathSum(int[][] grid) {
        // preprocess
        for(int i = 1; i < grid.length; i++){
            grid[i][0] = grid[i-1][0]+grid[i][0];
        }
        for(int i = 1; i < grid[0].length; i++){
            grid[0][i] = grid[0][i-1]+grid[0][i];
        }
        
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
