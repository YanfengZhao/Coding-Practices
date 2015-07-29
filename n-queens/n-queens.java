/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

// Backtracking recursion. 
// Traverse every column, construct a string and add to curBoard. Check if current board is valid. 
// If the board is valid, call recursive function and add the next row and check if what just added is valid.
// If length of curBoard == n, then it means found a solution, which is the base case.

public class Solution {
    List<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        helper(n,new ArrayList<String>());
        return result;
    }
    
    public void helper(int n, ArrayList<String> curBoard){
        if(curBoard.size()==n){
            result.add(new ArrayList<String>(curBoard));
            return;
        }
        
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(j == i){
                    sb.append("Q");
                }
                else{
                    sb.append(".");
                }
            }
            String row = sb.toString();
            curBoard.add(row);
            if(checkValid(n,curBoard,i)){
                helper(n,curBoard);
            }
            curBoard.remove(curBoard.size()-1);
        }
    }
    
    public boolean checkValid(int n, ArrayList<String> curBoard, int col){
        int row = curBoard.size()-1;
        for(int i = 0; i < row; i++){ // compare the recent addition Q to the past Qs
            for(int j = 0; j < n; j++){
                if(curBoard.get(i).charAt(j) == 'Q'){
                    if(col == j){
                        return false;
                    }
                    if(Math.abs(col-j)==Math.abs(row-i)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
