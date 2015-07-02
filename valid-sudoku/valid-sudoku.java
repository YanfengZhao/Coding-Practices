/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

// Check each row, then each column, then each of the 9 boxes

public class Solution {
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
