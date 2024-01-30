package edu.project2;

public class Maze {
    private final int width = 25;
    private final int height = 25;
    private final char[][] maze;
    private final int startX = 1;
    private final int startY = 1;
    private final int finishX = 23;
    private final int finishY = 1;

    public Maze() {
        this.maze = new char[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMaze() {
        return maze;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getFinishX() {
        return finishX;
    }

    public int getFinishY() {
        return finishY;
    }

    public void initializeMaze() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = '#';
            }
        }
    }

    public void markStartAndExit() {
        maze[startY][startX] = 'S';
        maze[finishX][finishY] = 'F';
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void printMaze() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}
