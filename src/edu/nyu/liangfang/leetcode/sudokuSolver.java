package edu.nyu.liangfang.leetcode;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class sudokuSolver {
	
	// AC solution - backtracking: pass a current result to recursion function
	public void solveSudoku(char[][] board) {
		solve(board);				// 为了在找到所有正确数字后结束，将solve设计为一个return boolean的函数
	}
	
	private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidFill(board, i, j, c)) {	// 填数字前检查是否valid
                            board[i][j] = c;
                            if (solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    // for a empty cell, there must be a valid number, if not, means wrong number fill in previous empty cell
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValidFill(char[][] board, int i, int j, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c || board[k][j] == c) 
                return false;
        }
        
        // each 3x3 cube contains the same number only once - only check the cube that (i,j) is in !!!
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++)
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) 
                if (board[row][col] == c)
                    return false;
        return true;
    }

}
