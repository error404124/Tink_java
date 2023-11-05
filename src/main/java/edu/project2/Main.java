package edu.project2;

public class Main {
    private Main() {

    }

    public static void main(String[] args) {
        MazeGenerator mazeGenerator = new MazeGenerator();
        mazeGenerator.generateMaze();
        mazeGenerator.printMaze();
    }
}
