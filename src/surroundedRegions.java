package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class surroundedRegions {
	
	// BFS:  time O(n^2)  space O(n^2)
	public void solve(char[][] board) {
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
