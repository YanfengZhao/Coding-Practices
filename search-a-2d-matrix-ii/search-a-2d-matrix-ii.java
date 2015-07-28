/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/

// Similar to BST.
// Starting at top right corner. If equal to target, return true, if less than target, move down, else move left.

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        
        int startR = matrix[0].length-1;
        int startC = 0;
        while(startC < matrix.length && startR >= 0){
            if(matrix[startC][startR] == target){
                return true;
            }
            
            // if greater than target, move left
            else if(matrix[startC][startR] < target){
                startC++;
            }
            // if less than target, move down
            else if(matrix[startC][startR] > target){
                startR--;
            }
        }
        return false;
    }
}
