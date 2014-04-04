import java.util.ArrayList;

/*
 * CTCI Chap 9    9.9
 */
public class EightQueens {
	private int GRID_SIZE = 8;
	public void placeQueens(int row, Integer[] colPos, ArrayList<Integer[]> results) {
		if (row == GRID_SIZE)
			results.add(colPos);
		else {
			for (int col = 0; col < GRID_SIZE; col++) {
				if (isValid(row, col, colPos)) {
					colPos[row] = col;
					placeQueens(row + 1, colPos, results);
				}
			}
		}
	}
	
	public boolean isValid(int row, int col, Integer[] colPos) {
		for (int row2 = 0; row2 < row; row2++) {
			int col2 = colPos[row2];
			if (col2 == col)
				return false;
			if (Math.abs(col2 - col) == Math.abs(row2 - row)) {
				return false;
			}
		}
		return true;
	}
}
