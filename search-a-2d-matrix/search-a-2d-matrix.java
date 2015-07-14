/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

// Use binary search twice. First time binary search the rows and check first element.
// If found, return true. If not found, found the row with first element closest to target but less than target.
// Binary search that row. If found return true, otherwise return false.

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0){
			return false;
		}
        int start = 0;
        int end = matrix.length-1;
        int mid = 0;
        int closestLessThanRowIndex = 0; // less than target
        // search in rows
        while(start<=end){
        	mid = (start+end)/2;
        	if(matrix[mid][0] == target){
        		return true;
        	}
        	if(matrix[mid][0] < target){
        		if(mid > closestLessThanRowIndex){
        			closestLessThanRowIndex = mid;
        		}
        		start = mid+1;
        	}
        	else if(matrix[mid][0] > target){
        		end = mid-1;
        	}
        }
        // search in columns
        start = 0;
        end = matrix[0].length-1;
        while(start<=end){
        	mid = (start+end)/2;
        	if(matrix[closestLessThanRowIndex][mid] == target){
        		return true;
        	}
        	else if(matrix[closestLessThanRowIndex][mid] > target){
        		end = mid - 1;
        	}
        	else{
        		start = mid+1;
        	}
        }
        return false;
    }
}
