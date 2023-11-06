package edu.project2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    void test1() {
        Boolean answer = true;
        MazeGenerator mazeGenerator = new MazeGenerator();
        assertThat(answer).isEqualTo(mazeGenerator.findPath());
    }

    @Test
    void test2() {
        Boolean answer = true;
        MazeGenerator mazeGenerator = new MazeGenerator();
        assertThat(answer).isEqualTo(mazeGenerator.generatePaths(1, 1));
    }
}
