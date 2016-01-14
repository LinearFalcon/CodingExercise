package edu.nyu.liangfang.leetcode;
import java.util.HashSet;
import java.util.Set;


public class validSudoku {
	// New and clean
	public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet();
        Set<Character> colSet = new HashSet();
        Set<Character> cubeSet = new HashSet();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) return false;
                if (board[j][i] != '.' && !colSet.add(board[j][i])) return false;
            }
            rowSet.clear();
            colSet.clear();
        }
        
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 3; k++) {
                    for (int m = 0; m < 3; m++) {
                        if (board[i + k][j + m] != '.' && !cubeSet.add(board[i + k][j + m])) 
                            return false;
                    }
                }
                cubeSet.clear();
            }
        }
        return true;
    }


	// Old
	public boolean isValidSudoku_old(char[][] board) {
		Set<Character> rowSet = new HashSet<Character>(); 
		Set<Character> colSet = new HashSet<Character>();
		Set<Character> cubeSet = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (rowSet.contains(board[i][j])) {
						return false;
					}
					rowSet.add(board[i][j]);
				}

				if (board[j][i] != '.') {
					if (colSet.contains(board[j][i])) {
						return false;
					}
					colSet.add(board[j][i]);
				}
			}
			rowSet.clear();
			colSet.clear();
		}

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				
				for (int k = 0; k < 3; k++) {
					for (int m = 0; m < 3; m++) {
						char ch = board[i + k][j + m];
						if (ch != '.') {
							if (cubeSet.contains(ch)) {
								return false;
							}
							cubeSet.add(ch);
						}
					}
				}
				cubeSet.clear();
			}
		}

		return true;     
	}
}
