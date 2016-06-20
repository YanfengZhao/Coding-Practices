/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/

// Store the next state in the same board as a bit.
// First bit next round.
// Second bit current round.

public class Solution {
    public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int lives = countLives(board, i, j);
				// Any live cell with fewer than two live neighbors dies, as if
				// caused by under-population.
				if (board[i][j] == 1 && lives < 2) {
					board[i][j] = 1;
				}
				// Any live cell with two or three live neighbors lives on to
				// the next generation.
				else if (board[i][j] == 1 && (lives == 2 || lives == 3)) {
					board[i][j] = 3;
				}
				// Any live cell with more than three live neighbors dies, as if
				// by over-population.
				else if (board[i][j] == 1 && lives > 3) {
					board[i][j] = 1;
				}
				// Any dead cell with exactly three live neighbors becomes a
				// live cell, as if by reproduction.
				else if (board[i][j] == 0 && lives == 3) {
					board[i][j] = 2;
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = board[i][j] >> 1;
			}
		}
	}

	public int countLives(int[][] board, int i, int j) {
		int count = 0;
		for (int m = Math.max(0, i - 1); m <= Math.min(i + 1, board.length - 1); m++) {
			for (int n = Math.max(0, j - 1); n <= Math.min(j + 1, board[0].length - 1); n++) {
				if (m == i && n == j) {
					continue;
				}
				count += board[m][n] & 1;
			}
		}
		return count;
	}
}
