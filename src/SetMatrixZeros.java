
public class SetMatrixZeros {
	public void setZeroes(int[][] matrix) {			// O(1) space ********
		int row = matrix.length;
        int col = matrix[0].length;
        boolean firstColHasZero = false, firstRowHasZero = false;
        for (int i = 0; i < row; i++) { 		//check if first column has zero
        	if (matrix[i][0] == 0) {
        		firstColHasZero = true;
        	}
        		
        }
        
        for (int i = 0; i < col; i++) { 		//check if first row has zero
        	if (matrix[0][i] == 0) {
        		firstRowHasZero = true;
        	}
        		
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j]  == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for (int i = 1; i < row; i++) {			// Do not change first row and first column, because 
            for (int j = 1; j < col; j++) {		// it will affect later one, since we use first row and first column to as flag
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        
        if (firstRowHasZero) {					// In the final, nullify first row and column if necessary
        	for (int i = 0; i < col; i++)
        		matrix[0][i] = 0;
        }
        if (firstColHasZero) {
        	for (int i = 0; i < row; i++)
        		matrix[i][0] = 0;
        }
    }
	
	public void setZeroes2(int[][] matrix) {	// O(m+n) space ***
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rows = new int[row];
        int[] cols = new int[col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j]  == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rows[i] == 1 || cols[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }
}
