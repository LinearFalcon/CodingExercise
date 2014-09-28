package edu.nyu.liangfang.leetcode;

public class wordSearch {
	public boolean exist(char[][] board, String word) {
        int rowLen = board.length;
        int colLen = board[0].length;
        if (rowLen == 0 || colLen == 0 || word.length() == 0)
            return false;
        boolean[][] visited = new boolean[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (check(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean check(char[][] board, String word, int wordIndex, int row, int col, boolean[][] visited) {
        int rowLen = board.length;
        int colLen = board[0].length;
        
        if (row < 0 || row >= rowLen || col < 0 || col >= colLen) {
            return false;
        } else if (visited[row][col]) {
            return false;
        } else if (board[row][col] != word.charAt(wordIndex)) {
            return false;
        } else if (wordIndex == word.length() - 1) {
            return true;
        }
        
        visited[row][col] = true;
        if (check(board, word, wordIndex + 1, row - 1, col, visited))
            return true;
        if (check(board, word, wordIndex + 1, row + 1, col, visited))
            return true;
        if (check(board, word, wordIndex + 1, row, col - 1, visited))
            return true;
        if (check(board, word, wordIndex + 1, row, col + 1, visited))
            return true;
        visited[row][col] = false;	// Must roll back to previous state
        return false;
    }
}
