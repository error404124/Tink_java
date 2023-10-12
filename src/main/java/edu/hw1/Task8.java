package edu.hw1;

public class Task8 {
    public static boolean knightBoardCapture(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; ++i) {
            for (int j = 0; j < matrix[0].length - 1; ++j) {
                if (matrix[i][j] == 1) {
                    if (i + 1 < 8 && j + 2 < 8) {
                        if (matrix[i + 1][j + 2] == 1) {
                            return false;
                        }
                    }
                    if (i + 2 < 8 && j + 2 < 8) {
                        if (matrix[i + 2][j + 1] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
