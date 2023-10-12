package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task8.knightBoardCapture;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask8 {
    @Test
    void knightBoardCapture_test1() {
        int[][] desk = new int[][] {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}};
        boolean ans = true;
        assertThat(ans).isEqualTo(knightBoardCapture(desk));
    }
    @Test
    void knightBoardCapture_test2() {
        int[][] desk = new int[][] {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}};
        boolean ans = false;
        assertThat(ans).isEqualTo(knightBoardCapture(desk));
    }
    @Test
    void knightBoardCapture_test3() {
        int[][] desk = new int[][] {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 0, 0}};
        boolean ans = false;
        assertThat(ans).isEqualTo(knightBoardCapture(desk));
    }
}
