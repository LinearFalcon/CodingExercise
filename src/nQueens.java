package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nQueens {
	// O(n) space，可以用一维数组来存每一行Queen所在的列的位置
	public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        if (n <= 0) {
            return result;
        }
        int[] colPos = new int[n];
        Arrays.fill(colPos, -1);    // must initialize to -1 !
        findSolutions(n, result, 0, colPos);
        return result;
    }
    
    private void findSolutions(int n, List<String[]> result, int currRow, int[] colPos) {
        if (currRow == n) {
            String[] sol = new String[n];
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (colPos[i] != j) {
                        sb.append('.');
                    } else {
                        sb.append('Q');
                    }
                }
                sol[i] = sb.toString();
            }
            result.add(sol);
            
            return;
        }
        
        for (int j = 0; j < n; j++) {
            colPos[currRow] = j;
            if (isValid(colPos, currRow, j, n)) {
                findSolutions(n, result, currRow + 1, colPos);
            }
            colPos[currRow] = -1;
        }
    }
    // 已经保证了每行一个皇后，只需要判断列是否合法以及对角线是否合法。
    private boolean isValid(int[] colPos, int row, int col, int n) {
        
        for (int i = 0; i < row; i++) {
        	// 如果两个Queen在同一个对角线上，则他们的row之差肯定等于column之差
            if (colPos[i] == col || Math.abs(row - i) == Math.abs(col - colPos[i])) {
                return false;
            }
        }
        
        return true;
    }
	
	
	// O(n^2) space
	public List<String[]> solveNQueens_2(int n) {
        List<String[]> result = new ArrayList<String[]>();
        if (n <= 0) {
            return result;
        }
        char[][] board = new char[n][n];
        findSolutions(n, result, 0, board);
        return result;
    }
    
    private void findSolutions(int n, List<String[]> result, int currRow, char[][] board) {
        if (currRow == n) {
            String[] sol = new String[n];
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 'Q') {	// 注意因为有些cell既不是‘Q’也不是‘.’
                        sb.append('.');
                    } else {
                        sb.append(board[i][j]);
                    }
                }
                sol[i] = sb.toString();
            }
            result.add(sol);
            
            return;
        }
        
        for (int j = 0; j < n; j++) {
            board[currRow][j] = 'Q';
            if (isValid(board, currRow, j, n)) {	// 只有能够放置当前queen才继续找剩余的可能
                findSolutions(n, result, currRow + 1, board);
            }
            board[currRow][j] = '.';
        }
    }
    
    private boolean isValid(char[][] board, int row, int col, int n) {
        // check this row and this column
        // only contain no more than 1 Queen
        int rowCount = 0;
        int colCount = 0;
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q') {
                rowCount++;
            }
            if (board[i][col] == 'Q') {
                colCount++;
            }
        }
        if (rowCount > 1 || colCount > 1) {
            return false;
        }
        
        // check each diagonal has no more than 1 Queen
        
        // 左对角线(只需要判断对角线上半部分，因为后面的行还没有开始放置)
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        // 右对角线(只需要判断对角线上半部分，因为后面的行还没有开始放置)
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        
        return true;
    }
}
