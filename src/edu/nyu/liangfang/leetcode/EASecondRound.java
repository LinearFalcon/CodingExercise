package edu.nyu.liangfang.leetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/*

There is a matrix consisting of positive integers, negative integers, and zeroes.
A robot travels from top left element to the bottom right element. It can only
moves right or moves down in each step. And it cannot pass elements with negative
integers. At each element along the path, for each (above, below, left, right)
adjacent off-path element with negative integers, its negative value will be
added to the sum of the path, i.e., it reduces the value of the path.
 
Please write a time-efficient program that reads a matrix data file (one row per
line with TAB character as the delimiter), and print
 
a) a non-loop path from the starting element to the ending element where the
   sum of the numbers along the path is the largest
b) the value of the sum.
 
Example matrix:
 
----------
| 2 | -3 |
----------
| 0 |  1 |
----------
 
Input matrix file:
 
2 -3
0 1
 
Output:
 
-3
2 -> 0 -> 1
 
The path with maximum sum of numbers is 2 -> 0 -> 1 and the final sum is
(2-3)+0+(1-3) = -3. We add -3 twice to the sum at elements with value 2 and 1.

 */


class PointEA {
    public int x;
    public int y;
    public int value;
    public int sum;
    PointEA parent;        // last PointEA in shortest path

    public PointEA(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
        sum = Integer.MIN_VALUE;
        parent = null;
    }

    public void setSum(int i) {
        this.sum = i;
    }
}

public class EASecondRound {
    public void printPath() {

        PointEA[][] matrix = readMatrix();
        matrix[0][0].setSum(matrix[0][0].value);
        if (matrix[0][1].value < 0)
            matrix[0][0].sum += matrix[0][1].value;
        if (matrix[1][0].value < 0)
            matrix[0][0].sum += matrix[1][0].value;
        relax(matrix, matrix[0][0]);

        int row = matrix.length;
        int col = matrix[0].length;
        PointEA p = matrix[row - 1][col - 1];
        int sum = p.sum;                    // sum of shortest path
        ArrayList<Integer> info = new ArrayList<Integer>();
        while (p != null) {
            info.add(p.value);
            p = p.parent;
        }

        System.out.println(sum);
        for (int i = info.size() - 1; i >= 0; i--) {
            if (i > 0)
                System.out.print(info.get(i) + " -> ");
            else
                System.out.print(info.get(i));
        }
    }

    public void relax(PointEA[][] matrix, PointEA p) {
        if (p.y < matrix[0].length - 1 && matrix[p.x][p.y + 1].value >= 0) {
            PointEA right = matrix[p.x][p.y + 1];

            int temp = p.sum + right.value;
            if (right.x > 0 && matrix[right.x - 1][right.y].value < 0) {
                temp += matrix[right.x - 1][right.y].value;
            }
            if (right.y < matrix[0].length - 1 && matrix[right.x][right.y + 1].value < 0) {
                temp += matrix[right.x][right.y + 1].value;
            }
            if (right.x < matrix.length - 1 && matrix[right.x + 1][right.y].value < 0) {
                temp += matrix[right.x + 1][right.y].value;
            }

            if (temp > right.sum) {
                right.parent = p;
                right.sum = temp;
            }

            relax(matrix, right);
        }

        if (p.x < matrix.length - 1 && matrix[p.x + 1][p.y].value >= 0) {
            PointEA down = matrix[p.x + 1][p.y];

            int temp = p.sum + down.value;
            if (down.y > 0 && matrix[down.x][down.y - 1].value < 0) {
                temp += matrix[down.x][down.y - 1].value;
            }
            if (down.y < matrix[0].length - 1 && matrix[down.x][down.y + 1].value < 0) {
                temp += matrix[down.x][down.y + 1].value;
            }
            if (down.x < matrix.length - 1 && matrix[down.x + 1][down.y].value < 0) {
                temp += matrix[down.x + 1][down.y].value;
            }

            if (temp > down.sum) {
                down.parent = p;
                down.sum = temp;
            }

            relax(matrix, down);
        }

    }

    public PointEA[][] readMatrix() {
        BufferedReader br = null;
        PointEA[][] result = null;
        ArrayList<int[]> matrixInfo = new ArrayList<int[]>();
        try {
            String currentLine;
            br = new BufferedReader(new FileReader("/Users/liangfang/Desktop/test4.txt"));
            while ((currentLine = br.readLine()) != null) {
                String[] temp = currentLine.split("\t");

                int[] arr = new int[temp.length];
                for (int i = 0; i < temp.length; i++) {        // convert string element to int type
                    arr[i] = Integer.parseInt(temp[i]);
                }
                matrixInfo.add(arr);

                result = new PointEA[matrixInfo.size()][arr.length];
                for (int i = 0; i < matrixInfo.size(); i++) {
                    for (int j = 0; j < arr.length; j++) {
                        result[i][j] = new PointEA(i, j, matrixInfo.get(i)[j]);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
