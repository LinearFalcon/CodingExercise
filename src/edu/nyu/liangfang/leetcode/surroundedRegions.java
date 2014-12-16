package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class surroundedRegions {
	
	// DFS and iterate over, space O(1), time O(m*n)
	public void solve(char[][] board) {
        int row = board.length;
        if (row < 2) {
            return;
        }
        int col = board[0].length;
        if (col < 2) {
            return;
        }
        
        // search first column and last column
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '#';
                dfs(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                board[i][col - 1] = '#';
                dfs(board, i, col - 1);
            }
        }
        
        // search first and last row
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '#';
                dfs(board, 0, j);
            }
            if (board[row - 1][j] == 'O') {
                board[row - 1][j] = '#';
                dfs(board, row - 1, j);
            }
        }
        
        // change all 'O' into 'X' and all '#' into 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void dfs(char[][] board, int row, int col) {
        if (row > 1 && board[row - 1][col] == 'O') {
            board[row - 1][col] = '#';
            dfs(board, row - 1, col);
        }
        if (row < board.length - 1 && board[row + 1][col] == 'O') {
            board[row + 1][col] = '#';
            dfs(board, row + 1, col);
        }
        if (col > 1 && board[row][col - 1] == 'O') {
            board[row][col - 1] = '#';
            dfs(board, row, col - 1);
        }
        if (col < board[0].length - 1 && board[row][col + 1] == 'O') {
            board[row][col + 1] = '#';
            dfs(board, row, col + 1);
        }
    }
	
    
	// BFS:  time O(n^2)  space O(n^2)
	public void solve_BFS(char[][] board) {
        if (board.length == 0) 
            return;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        // for each unvisited 'O', BFS search all adjacent 'O' to see if these 'O's are surrounded
        // If so, set them to 'X' and mark all of them visited
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((board[i][j] == 'O') && !visited[i][j]) {                	
                    check(board, i, j, visited);
                }
            }
        }
    }
    
    private void check(char[][] board, int i, int j, boolean[][] visited) {
        Queue<Integer> rowQ = new LinkedList<Integer>();
        Queue<Integer> colQ = new LinkedList<Integer>();
        ArrayList<Integer> rowList = new ArrayList<Integer>();
        ArrayList<Integer> colList = new ArrayList<Integer>();
        
        visited[i][j] = true;
        rowList.add(i);
        colList.add(j);
        
        rowQ.add(i);
        colQ.add(j);
        boolean hasPointOnEdge = false;
        while (!rowQ.isEmpty()) {
            int row = rowQ.poll();
            int col = colQ.poll();
            
            // this 0 is on the edge of board
            if (row == 0 || row == board.length - 1 || col == 0 || col == board[0].length - 1) {
                hasPointOnEdge = true;
            }
            
            // add valid neighbors into queue, check four directions, cannot use 'else if' !!!!!!
            if (row != 0) {
                if (!visited[row - 1][col] && board[row - 1][col] == 'O') {
                    rowQ.add(row - 1);
                    colQ.add(col);
                    visited[row - 1][col] = true;
                    rowList.add(row - 1);
                    colList.add(col);
                }
            } 
            if (row != board.length - 1) {
                if (!visited[row + 1][col] && board[row + 1][col] == 'O') {
                    rowQ.add(row + 1);
                    colQ.add(col);
                    visited[row + 1][col] = true;
                    rowList.add(row + 1);
                    colList.add(col);
                }
            } 
            if (col != 0) {
                if (!visited[row][col - 1] && board[row][col - 1] == 'O') {
                    rowQ.add(row);
                    colQ.add(col - 1);
                    visited[row][col - 1] = true;
                    rowList.add(row);
                    colList.add(col - 1);
                }
            } 
            if (col != board[0].length - 1) {
                if (!visited[row][col + 1] && board[row][col + 1] == 'O') {
                    rowQ.add(row);
                    colQ.add(col + 1);
                    visited[row][col + 1] = true;
                    rowList.add(row);
                    colList.add(col + 1);
                }
            }
        }
        if (!hasPointOnEdge) {
            for (int index = 0; index < rowList.size(); index++) {
                board[rowList.get(index)][colList.get(index)] = 'X';
            }
        }
    }
}
