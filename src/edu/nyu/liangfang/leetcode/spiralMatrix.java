package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return result;
        }

        // current row and column number
        int row = matrix.length;
        int col = matrix[0].length;

        int x = 0;
        int y = 0;
        while (row > 0 && col > 0) {
            // if only one row
            if (row == 1) {
                for (int i = 0; i < col; i++) {
                    result.add(matrix[x][y++]);
                }
                break;
            } else if (col == 1) {      // if only one column
                for (int i = 0; i < row; i++) {
                    result.add(matrix[x++][y]);
                }
                break;
            }

            // top 
            for (int i = 0; i < col - 1; i++) {
                result.add(matrix[x][y++]);
            }
            //right
            for (int i = 0; i < row - 1; i++) {
                result.add(matrix[x++][y]);
            }
            // bottom
            for (int i = 0; i < col - 1; i++) {
                result.add(matrix[x][y--]);
            }
            // left
            for (int i = 0; i < row - 1; i++) {
                result.add(matrix[x--][y]);
            }

            x++;
            y++;
            row -= 2;
            col -= 2;
        }
        return result;
    }
}
