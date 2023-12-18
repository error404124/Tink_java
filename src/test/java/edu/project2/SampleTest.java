package edu.project2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    void findPathTest() {
        Maze maze = new Maze();
        MazeGenerator mazeGenerator = new MazeGenerator(maze);
        mazeGenerator.generateMaze();
        assertThat(mazeGenerator.getPathFinder().findPath()).isTrue();
    }

    @Test
    void generatePathsTest() {
        Maze maze = new Maze();
        MazeGenerator mazeGenerator = new MazeGenerator(maze);
        mazeGenerator.generatePaths(1, 1);
        char[][] generatedMaze = maze.getMaze();
        boolean pathsGenerated = false;
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (generatedMaze[i][j] == ' ') {
                    pathsGenerated = true;
                    break;
                }
            }
            if (pathsGenerated) {
                break;
            }
        }

        assertThat(pathsGenerated).isTrue();
    }
    @Test
    public void printMazeAndPathTest() {
        Maze maze = new Maze();
        MazeGenerator mazeGenerator = new MazeGenerator(maze);
        mazeGenerator.generateMazePath();

        maze.printMaze();
    }

    @Test
    void pathNotFoundTest() {
        Maze maze = new Maze();
        PathFinder pathFinder = new PathFinder(maze);
        maze.initializeMaze();

        assertThat(pathFinder.findPath()).isFalse();
    }

    @Test
    void mazeStartAndFinishTest() {
        Maze maze = new Maze();
        assertThat(maze.getStartX()).isEqualTo(1);
        assertThat(maze.getStartY()).isEqualTo(1);
        assertThat(maze.getFinishX()).isEqualTo(23);
        assertThat(maze.getFinishY()).isEqualTo(1);
    }
}
