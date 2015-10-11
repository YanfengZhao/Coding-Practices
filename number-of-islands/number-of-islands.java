/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

// Solution 1. Better solution. Without visited-2D-array.
// Traverse the grid array. If seeing a 1, add to counter and call dfs method.
// In dfs method, if out of bounds or currently seeing a 0, return immediately.
// Set the current location in grid to 0 (mark as visited), and then call dfs on 4 adjacent blocks.

public class Solution {
    public int numIslands(char[][] grid) {
        int counter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    counter++;
                    dfs(i,j,grid);
                }
            }
        }
        return counter;
    }
    
    public void dfs(int i, int j, char[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0'){
            return;
        }
        
        grid[i][j] = '0';
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
    }
}

// Traverse the grid.
// Keep track of visited nodes in a 2D array.
// Call bfs helper function on a single land to get surrounding land, after counting mark them water.
// Return count.

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    count++;
                    bfsHelper(grid,visited,i,j);
                }
            }
        }
        return count;
    }
    
    public void bfsHelper(char[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true){
            return;
        }
        
        visited[i][j] = true;
        if(grid[i][j] == '1'){
            bfsHelper(grid,visited,i-1,j);
            bfsHelper(grid,visited,i+1,j);
            bfsHelper(grid,visited,i,j-1);
            bfsHelper(grid,visited,i,j+1);
        }
    }
}
