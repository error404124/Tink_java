package edu.project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazeGenerator {
    private final Maze maze;

    public MazeGenerator(Maze maze) {
        this.maze = maze;
    }

    public void generateMaze() {
        maze.initializeMaze();
        generatePaths(maze.getStartX(), maze.getStartY());
        maze.markStartAndExit();
    }

    public void generateMazePath() {
        maze.initializeMaze();
        generatePaths(maze.getStartX(), maze.getStartY());
        getPathFinder().findPath();
    }

    void generatePaths(int x, int y) {
        maze.getMaze()[x][y] = ' ';
        List<int[]> directions =
            new ArrayList<>(List.of(new int[] {0, 1}, new int[] {0, -1}, new int[] {1, 0}, new int[] {-1, 0}));
        Collections.shuffle(directions);

        for (int[] route : directions) {
            int nextX = x + 2 * route[0];
            int nextY = y + 2 * route[1];

            if (nextX >= 0 && nextY >= 0 && nextX < maze.getHeight() && nextY < maze.getWidth()
                && maze.getMaze()[nextX][nextY] == '#') {
                maze.getMaze()[x + route[0]][y + route[1]] = ' ';
                generatePaths(nextX, nextY);
            }
        }
    }

    PathFinder getPathFinder() {
        return new PathFinder(maze);
    }
}
