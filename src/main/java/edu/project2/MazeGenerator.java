package edu.project2;

import java.util.Random;

@SuppressWarnings({"MagicNumber", "MissingSwitchDefault", "RegexpSinglelineJava"})
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

    private void initializeMaze() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = '#';
            }
        }
    }

    private void generatePaths(int x, int y) {
        maze[y][x] = ' ';

        int[] directions = {1, 2, 3, 4};
        shuffleArray(directions);

        for (int direction : directions) {
            switch (direction) {
                case 1:
                    if (y - 2 <= 0) {
                        continue;
                    }
                    if (maze[y - 2][x] != ' ') {
                        maze[y - 2][x] = ' ';
                        maze[y - 1][x] = ' ';
                        generatePaths(x, y - 2);
                    }
                    break;
                case 2:
                    if (x + 2 >= width - 1) {
                        continue;
                    }
                    if (maze[y][x + 2] != ' ') {
                        maze[y][x + 2] = ' ';
                        maze[y][x + 1] = ' ';
                        generatePaths(x + 2, y);
                    }
                    break;
                case 3:
                    if (y + 2 >= height - 1) {
                        continue;
                    }
                    if (maze[y + 2][x] != ' ') {
                        maze[y + 2][x] = ' ';
                        maze[y + 1][x] = ' ';
                        generatePaths(x, y + 2);
                    }
                    break;
                case 4:
                    if (x - 2 <= 0) {
                        continue;
                    }
                    if (maze[y][x - 2] != ' ') {
                        maze[y][x - 2] = ' ';
                        maze[y][x - 1] = ' ';
                        generatePaths(x - 2, y);
                    }
                    break;
            }
        }
    }

    private void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
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
