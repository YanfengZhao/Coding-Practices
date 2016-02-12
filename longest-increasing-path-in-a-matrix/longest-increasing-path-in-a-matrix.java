/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

// This second algorithm isn't the most efficient. Time limit exceeded on Leetcode test but gives the right result.
// For example
// nums = [
//   [9,9,4],
//   [6,6,8],
//   [2,1,1]
// ]
// the cache progression looks like this
// [[1, 0, 0], [0, 0, 0], [0, 0, 0]]
// [[1, 1, 0], [0, 0, 0], [0, 0, 0]]
// [[1, 2, 1], [0, 0, 2], [0, 0, 0]]
// [[2, 2, 1], [1, 0, 2], [0, 0, 0]]
// [[2, 2, 1], [1, 1, 2], [0, 0, 0]]
// [[2, 2, 1], [1, 1, 1], [0, 0, 0]]
// [[3, 2, 1], [2, 1, 1], [1, 0, 0]]
// [[4, 3, 1], [3, 2, 3], [2, 1, 0]]
// [[4, 3, 1], [3, 2, 3], [2, 1, 1]]

public class Solution {
    int result = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
            	cache[i][j] = 1;
                dfs(matrix, i, j, 0, Integer.MIN_VALUE,cache);
                //System.out.println(Arrays.deepToString(cache));
            }
        }
        return result;
    }
    public void dfs(int[][] matrix, int i, int j, int count, int prev,int[][] cache){
        if(i<0 || j<0 || i>matrix.length-1 || j>matrix[0].length-1){
            return;
        }
        
        if(matrix[i][j]>prev){
            count++;
            if(count < cache[i][j]){
                return;
            }
            else{
                cache[i][j] = count;
            }
            if(count > result){
                result = count;
            }
            
            dfs(matrix,i+1,j,count,matrix[i][j],cache);
            dfs(matrix,i-1,j,count,matrix[i][j],cache);
            dfs(matrix,i,j+1,count,matrix[i][j],cache);
            dfs(matrix,i,j-1,count,matrix[i][j],cache);
        }
    }
}
