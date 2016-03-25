/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

// Find the shorter side of columns and rows, divide it by 2, you want to iterate up to that layer.
// For each later, print each side of the layer.

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0){
            return result;
        }
        int r = matrix.length-1;
        int c = matrix[0].length-1;
        
        int iterations = Math.min(c, r)/2;
        int layer = 0;
        while(layer <= iterations){
        	for(int i = layer; i <= c - layer; i++){
        		result.add(matrix[layer][i]);
        	}
        	for(int i = layer + 1; i <= r - layer; i++){
        		result.add(matrix[i][c-layer]);
        	}
        	for(int i = c - 1 - layer; i >=layer && layer != r -layer; i--){
        		result.add(matrix[r-layer][i]);
        	}
        	for(int i = r - 1 - layer; i >layer && layer != c -layer; i--){
        		result.add(matrix[i][layer]);
        	}
        	layer++;
        }
        return result;
    }
}

// Solution 2. Have different value for iteration based on the shorter
// of rows and cols is odd or even.

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0){
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int iteration;
        if(Math.min(rows,cols) %2 == 0){
            iteration = Math.min(rows,cols)/2;
        }
        else{
            iteration = Math.min(rows,cols)/2+1;
        }
        int layers = 0;
        
        while(layers < iteration){
            // top
            for(int i = layers; i <= cols - 2 - layers; i++){
                result.add(matrix[layers][i]);
            }
            
            // right
            for(int i = layers; i <= rows-1-layers; i++){
                result.add(matrix[i][cols-layers-1]);
            }
            
            // bottom
            for(int i = cols-layers-2; i > layers && layers != rows - 1 - layers; i--){
                result.add(matrix[rows-layers-1][i]);
            }
            
            // left
            for(int i = rows-layers-1; i > layers && layers != cols -1 - layers; i--){
                result.add(matrix[i][layers]);
            }
            layers++;
        }
        
        return result;
    }
}
