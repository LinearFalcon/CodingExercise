package edu.nyu.liangfang.leetcode;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class sudokuSolver {
	
	// AC solution
	public void solveSudoku(char[][] board) {
		solve(board);
	}
	
	private boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char num = '1'; num <= '9'; num++) {
						if (isValidFill(board, i, j, num)) {
							board[i][j] = num;
							if (solve(board)) {
								return true;
							} else { 
								// if not valid fill, then roll back to previous state
								board[i][j] = '.';
							}
						}
					}
					// for a empty cell, there must be a valid number, if not, means wrong number fill in previous empty cell
					return false;
				}
			}
		}
		return true;	// at last all empty cells are filled so here should return true
	}

	private boolean isValidFill(char[][] board, int i, int j, char numStr) {
		for (int row = 0; row < board.length; row++) {
			if (board[row][j] == numStr) {
				return false;
			}
		}
		for (int col = 0; col < board[0].length; col++) {
			if (board[i][col] == numStr) {
				return false;
			}
		}
		// each 3x3 box contains the same number only once - only check the box that (i,j) is in !!!
		for (int row = i/3*3; row < i/3*3 + 3; row++) {
			for (int col = j/3*3; col < j/3*3 + 3; col++) {
				if (board[row][col] == numStr) {
					return false;
				}
			}
		}
		return true;
	}

	// -------------- Time Limit Exceed Solution ---------------
	public void solveSudoku_TLE(char[][] board) {
		Hashtable<Integer, Set<Integer>> rowSet = new Hashtable<Integer, Set<Integer>>();
		Hashtable<Integer, Set<Integer>> colSet = new Hashtable<Integer, Set<Integer>>();
        
        // initialize rowSet and colSet
		for (int i = 0; i < board.length; i++) {
			rowSet.put(i, new HashSet<Integer>());
			colSet.put(i, new HashSet<Integer>());
		}
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    rowSet.get(i).add(board[i][j] - '0');
                    colSet.get(j).add(board[i][j] - '0');
                }
            }
        }
        
        fillBoard(board, 0, 0, rowSet, colSet);
    }
    
    private boolean fillBoard(char[][] board, int row, int col, 
    		Hashtable<Integer, Set<Integer>> rowSet, Hashtable<Integer, Set<Integer>> colSet) {
        if (row == board.length - 1 && col == board.length)
            return true;
        
        int i = row;
        int j = col;
        if (col == board.length) {
            i++;
            j = 0;
        }
                
        if (board[i][j] == '.') {
            for (int num = 1; num <= 9; num++) {
                if (!rowSet.get(i).contains(num) && !colSet.get(j).contains(num)) {
                    rowSet.get(i).add(num);
                    colSet.get(j).add(num);
                    board[i][j] = String.valueOf(num).charAt(0);
                    
                    // if this filling combination doesn't work, roll back to previous state
                    if (!fillBoard(board, i, j + 1, rowSet, colSet)) {
                        rowSet.get(i).remove(num);
                        colSet.get(j).remove(num);
                        board[i][j] = '.';
                    } else {
                        return true;
                    }
                }
            }
            return false;
        } else {
            return fillBoard(board, i, j + 1, rowSet, colSet);
        }
    }
}
