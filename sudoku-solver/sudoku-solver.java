/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/

// Backtracking recursion. Every recursive call deals with one single grid.

public class Solution {
    boolean foundResult = false;
    public void solveSudoku(char[][] board) {
        // call recursive method
        helper(board,0,0);
    }
    
    public void helper(char[][] board, int row, int col){
        if(row == 9){
            foundResult = true;
            return;
        }
        

        if(board[row][col] != '.'){ // only when it's '.' on the board, we skip evaluation
            if(col == 8){ // move on to next row
                helper(board,row+1,0);
            }
            else{ // same row next col
                helper(board,row,col+1);
            }
        }
        else{
            for(int t = 1; t <= 9; t++){
            	// enter the try in result
            	board[row][col] = (char) (t+'0');

                if(isValidSudoku(board)){
                    if(col == 8){ // move on to next row
                        helper(board,row+1,0);
                    }
                    else{ // same row next col
                        helper(board,row,col+1);
                    }
                    if(foundResult == true){
                    	return;
                    }
                }
                board[row][col] = '.';
            }
        }
    }
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hs = new HashSet<Character>();
        
        // check each row
        for(int i=0;i<board.length;i++){
            hs.clear();
            for(int j=0;j<board.length;j++){
                if(hs.contains(board[i][j])){
                    return false;
                }
                else{
                    if(board[i][j]!='.'){
                        hs.add(board[i][j]);
                    }
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            hs.clear();
            for(int j=0;j<board.length;j++){
                if(hs.contains(board[j][i])){
                    return false;
                }
                else{
                    if(board[j][i]!='.'){
                        hs.add(board[j][i]);
                    }
                }
            }
        }
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                hs.clear();
                if(checkBox(hs,i,j,board) == false){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkBox(HashSet<Character> hs, int i, int j, char[][] board){
        for(int m = i*3; m < 3*i+3; m++){
            for(int n = j*3; n < 3*j+3; n++){
                if(hs.contains(board[m][n])){
                    return false;
                }
                else{
                    if(board[m][n]!='.'){
                        hs.add(board[m][n]);
                    }
                }
            }
        }
        return true;
    }
}
