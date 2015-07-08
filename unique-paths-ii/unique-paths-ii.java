/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

// O(n^2). fill in the grid, build it based on information calculated before

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int c = obstacleGrid.length;
        int r = obstacleGrid[0].length;
        int[][] grid = new int[c][r];
        
        // fill in the ways for the first column with 1 unless blocked
        for(int i = 0; i < c; i++){
            if(obstacleGrid[i][0]!=1){
                grid[i][0] = 1;
            }
            else{
                break;
            }
        }
        // fill in the ways for the first row with 1 
        for(int i = 0; i < r; i++){
            if(obstacleGrid[0][i]!=1){
                grid[0][i] = 1;
            }
            else{
                break;
            }
        }
        for(int i = 1; i < c; i++){
            for(int j = 1; j < r; j++){
                if(obstacleGrid[i][j]==1){
                    grid[i][j] = 0;
                }
                else{
                    grid[i][j] = grid[i-1][j]+grid[i][j-1];
                }
            }
        }
        return grid[c-1][r-1];
    }
}
