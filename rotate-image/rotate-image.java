/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

// be careful in the for loop you are only traversing up to length of the side - 2, not including the last block

public class Solution {
    public void rotate(int[][] matrix) {
        int iterations = matrix.length/2;
        int length = matrix.length-1;
        int layer = 0;
        while(layer<iterations){
            for(int i = layer; i < length-layer; i++){
                int temp = matrix[layer][i];
                // move left to top
                matrix[layer][i] = matrix[length - i][layer];
                // move bottom to left
                matrix[length - i][layer] = matrix[length - layer][length - i];
                // move right to bottom
                matrix[length - layer][length - i] = matrix[i][length - layer];
                // move top to right
                matrix[i][length - layer] = temp;
            }
            layer++;
        }
    }
}
