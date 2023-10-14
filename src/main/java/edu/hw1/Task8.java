package edu.hw1;

public class Task8 {
    private Task8() {
    }

    @SuppressWarnings("MagicNumber")
    public static boolean knightBoardCapture(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 1) {
                    if (i + 1 < 8 && j + 2 < 8) {
                        if (matrix[i + 1][j + 2] == 1) {
                            return false;
                        }
                    }
                    if (i + 2 < 8 && j + 1 < 8) {
                        if (matrix[i + 2][j + 1] == 1 ) {
                            return false;
                        }
                    }
                    if (i + 1 < 8 && j - 2 >= 0){
                        if (matrix[i + 1][j - 2] == 1){
                            return false;
                        }
                    }
                    if (i + 2 < 8 && j - 1 >= 0){
                        if (matrix[i + 2][j - 1] == 1){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
