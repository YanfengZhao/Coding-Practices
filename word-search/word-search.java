/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

// Solution without the extra 2D array. Mark the spot '#', then change it back later.
// Traverse every element in board, assuming starting with each of those letter.
// Call recursive function, make sure the index accessing is not out of bounds and so on.
// Create a global variable called founded to avoid extra calculations.

public class Solution {
    boolean found = false;
    public boolean exist(char[][] board, String word) {
        if(board.length == 0){
            return false;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j <board[0].length; j++){
                if(helper(i,j,board,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean helper(int r, int c, char[][] board, String word, int index){
        if(found){
            return true;
        }
        
        // if ouf of bounds, return false
        if(r<0||c<0||r>=board.length||c>=board[0].length||board[r][c]=='#'){
            return false;
        }
        
        // if it is the last index of the word and it's equal to what's on the board, return true
        if(index == word.length()-1){
            if(board[r][c] == word.charAt(index)){
                found = true;
                return true;
            }
            else{
                return false;
            }
        }
        
        // if the character at index is not equal to the character in the board return false
        if(board[r][c] != word.charAt(index)){
            return false;
        }
        else{
            char temp = board[r][c];
            board[r][c] = '#';
            boolean down = helper(r+1,c,board,word,index+1);
            boolean left = helper(r,c-1,board,word,index+1);
            boolean top = helper(r-1,c,board,word,index+1);
            boolean right = helper(r,c+1,board,word,index+1);
            board[r][c] = temp;
            boolean result = down||left||top||right;
            if(result){
                found = true;
            }
            return result;
        }
    }
}

// Solution with the 2D array.
// Created a 2D array to keep track of visited locations.
// Traverse every element in board, assuming starting with each of those letter.
// Call recursive function, make sure the index accessing is not out of bounds and so on.
// Create a global variable called founded to avoid extra calculations.

public class Solution {
    boolean found = false;
    public boolean exist(char[][] board, String word) {
        if(board.length == 0){
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length]; 
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j <board[0].length; j++){
                if(helper(i,j,board,visited,word,0)){
                    return true;
                }
                else{
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    public boolean helper(int r, int c, char[][] board, boolean[][] visited, String word, int index){
        if(found){
            return true;
        }
        
        // if ouf of bounds, return false
        if(r<0||c<0||r>=board.length||c>=board[0].length){
            return false;
        }
        
        // if visited, return false
        if(visited[r][c] == true){
            return false;
        }
        
        // if it is the last index of the word and it's equal to what's on the board, return true
        if(index == word.length()-1){
            if(board[r][c] == word.charAt(index)){
                found = true;
                return true;
            }
            else{
                return false;
            }
        }
        
        // if the character at index is not equal to the character in the board return false
        if(board[r][c] != word.charAt(index)){
            return false;
        }
        else{
            visited[r][c] = true;
            boolean down = helper(r+1,c,board,visited,word,index+1);
            boolean left = helper(r,c-1,board,visited,word,index+1);
            boolean top = helper(r-1,c,board,visited,word,index+1);
            boolean right = helper(r,c+1,board,visited,word,index+1);
            visited[r][c] = false;
            boolean result = down||left||top||right;
            if(result){
                found = true;
            }
            return result;
        }
    }
}
