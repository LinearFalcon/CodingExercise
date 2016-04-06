package edu.nyu.liangfang.leetcode;

public class wordSearch {
    // clean code
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        } else if (board == null || board.length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, int row, int col, String word) {
        if (word.length() == 0) {
            return true;
        } else if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {   // check if go out of boundary
            return false;
        } else if (board[row][col] != word.charAt(0)) {
            return false;
        }

        board[row][col] = '\0';
        String s = word.substring(1);
        if (check(board, row - 1, col, s)) {
            return true;
        } else if (check(board, row + 1, col, s)) {
            return true;
        } else if (check(board, row, col - 1, s)) {
            return true;
        } else if (check(board, row, col + 1, s)) {
            return true;
        }
        board[row][col] = word.charAt(0);
        return false;
    }

    // O(1) space method
    public boolean exist2(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (check2(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean check2(char[][] board, int row, int col,
                          String word, int index) {
        if (index == word.length()) {        // The order of these three if statement is important,
            return true;                    // must first check if match first, then check if row or col exceed boundary
        }                                    // then check if character matches
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        char tmp = board[row][col];
        board[row][col] = '\0';            // assume word would not contain such character, this is used to avoid matching same cell more than once
        if (check(board, row + 1, col, word, index + 1)) {
            return true;
        }
        if (check(board, row - 1, col, word, index + 1)) {
            return true;
        }
        if (check(board, row, col + 1, word, index + 1)) {
            return true;
        }
        if (check(board, row, col - 1, word, index + 1)) {
            return true;
        }
        board[row][col] = tmp;

        return false;
    }


    // ------------------------- visited matrix method, O(m*n) space -------------------------
    public boolean exist_visited(char[][] board, String word) {
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
        visited[row][col] = false;    // Must roll back to previous state
        return false;
    }
}
