/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
	boolean firstRow0s = false;
	boolean firstColumn0s = false;
		
	// if a 0 appears, set the corresponding top and left to zero.
	// if on the edge, make sure mark first row all 0s and first column all 0s for later.
        for(int i = 0; i < matrix.length; i++){
        	for(int j = 0; j< matrix[0].length; j++){
        		if(matrix[i][j]==0){
        			if(i==0) firstRow0s = true;
        			if(j==0) firstColumn0s = true;
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }
        
        // here be careful to exclude the first row and column
        for(int i = 1; i < matrix.length; i++){
        	for(int j = 1; j< matrix[0].length; j++){
        		if(matrix[i][0] == 0 || matrix[0][j] == 0){
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        // if first row should be all 0s, set them 0
        if(firstRow0s == true){
        	for(int i = 0; i < matrix[0].length; i++){
        		matrix[0][i] = 0;
        	}
        }
        
        // if first column should be all 0s, set them 0
        if(firstColumn0s == true){
        	for(int i = 0; i < matrix.length; i++){
        		matrix[i][0] = 0;
        	}
        }	
    }
}
