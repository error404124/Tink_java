package edu.project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings({"MagicNumber", "RegexpSinglelineJava"})
public class MazeGenerator {
    private final int width = 25;
    private final int height = 25;
    private final char[][] maze;
    private final int startX = 1;
    private final int startY = 1;
    private final int finishX = 23;
    private final int finishY = 1;

    public MazeGenerator() {
        this.maze = new char[height][width];
    }

    public void generateMaze() {
        initializeMaze();
        generatePaths(startX, startY);
        markStartAndExit();
    }

    public void generateMazePath() {
        initializeMaze();
        generatePaths(startX, startY);
        markStartAndExit();
        findPath();
    }

    private void initializeMaze() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = '#';
            }
        }
    }

    public Boolean generatePaths(int x, int y) {
        maze[x][y] = ' ';
        List<int[]> directions =
            new ArrayList<>(List.of(new int[] {0, 1}, new int[] {0, -1}, new int[] {1, 0}, new int[] {-1, 0}));
        Collections.shuffle(directions);

        for (int[] route : directions) {
            int nextX = x + 2 * route[0];
            int nextY = y + 2 * route[1];

            if (nextX >= 0 && nextY >= 0 && nextX < height && nextY < width && maze[nextX][nextY] == '#') {
                maze[x + route[0]][y + route[1]] = ' ';
                generatePaths(nextX, nextY);
            }
        }
        return true;
    }

    public Boolean findPath() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        int[][] visited = new int[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(visited[i], -1);
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == finishX && y == finishY) {
                List<int[]> path = new ArrayList<>();
                int[] pos = new int[] {x, y};
                while (pos[0] != startX || pos[1] != startY) {
                    path.add(pos);
                    int px = pos[0];
                    int py = pos[1];
                    pos = new int[] {visited[px][py] / width, visited[px][py] % width};
                }
                for (int[] p : path) {
                    maze[p[0]][p[1]] = '.';
                }
                maze[finishX][finishY] = 'F';
                return true;
            }
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] dir : directions) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (nextX >= 0 && nextY >= 0 && nextX < height && nextY < width && maze[nextX][nextY] != '#'
                    && visited[nextX][nextY] == -1) {
                    queue.add(new int[] {nextX, nextY});
                    visited[nextX][nextY] = x * width + y;
                }
            }
        }
        return false;
    }

    private void markStartAndExit() {
        maze[startY][startX] = 'S';
        maze[finishX][finishY] = 'F';
    }

    public void printMaze() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}
