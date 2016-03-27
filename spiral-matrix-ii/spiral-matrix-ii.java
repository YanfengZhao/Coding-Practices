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

// Iterative solution.
// If n is a odd number, simply add the last num to the middle of the
// matrix at the very end of the program.

public class Solution {
    public int[][] generateMatrix(int n) {
        int layers = 0;
        int iteration = n/2;
        int[][] matrix = new int[n][n];
        
        int num = 1;
        while(layers<iteration){
            // top
            for(int i = layers; i < n-1-layers; i++){
                matrix[layers][i] = num;
                num++;
            }
            
            // right
            for(int i = layers; i < n-1-layers; i++){
                matrix[i][n-1-layers] = num;
                num++;
            }
            
            // bottom
            for(int i = n-1-layers; i>=layers+1; i--){
                matrix[n-1-layers][i] = num;
                num++;
            }
            
            // left
            for(int i = n-1-layers; i>=layers+1; i--){
                matrix[i][layers] = num;
                num++;
            }
            layers++;
        }
        // if odd
        if(n%2 != 0){
            matrix[n/2][n/2] = num;
        }
        return matrix;
    }
}

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
