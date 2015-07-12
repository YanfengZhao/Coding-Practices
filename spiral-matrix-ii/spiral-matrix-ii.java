/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

// Recursion. 
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        generateMatrix(result,0,n-1,count);
        return result;
    }
    
    public void generateMatrix(int[][] grid, int s, int e, int count){
        if(s>e){
            return;
        }
        if(s==e){
            grid[s][e] = count;
            return;
        }
        
        // fill top
        for(int i = s; i <= e; i++){
            grid[s][i] = count;
            count++;
        }
        
        // fill right
        for(int i = s+1; i <= e; i++){
            grid[i][e] = count;
            count++;
        }
        // fill bottom
        for(int i = e-1; i >= s; i--){
            grid[e][i] = count;
            count++;
        }
        
        // fill left
        for(int i = e-1; i > s; i--){
            grid[i][s] = count;
            count++;
        }
        generateMatrix(grid,s+1,e-1,count);
    }
}
