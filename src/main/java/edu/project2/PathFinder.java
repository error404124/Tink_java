package edu.project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathFinder {
    private final Maze maze;

    public PathFinder(Maze maze) {
        this.maze = maze;
    }

    public boolean findPath() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {maze.getStartX(), maze.getStartY()});
        int[][] visited = new int[maze.getHeight()][maze.getWidth()];
        for (int i = 0; i < maze.getHeight(); i++) {
            Arrays.fill(visited[i], -1);
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == maze.getFinishX() && y == maze.getFinishY()) {
                List<int[]> path = new ArrayList<>();
                int[] pos = new int[] {x, y};
                while (pos[0] != maze.getStartX() || pos[1] != maze.getStartY()) {
                    path.add(pos);
                    int px = pos[0];
                    int py = pos[1];
                    pos = new int[] {visited[px][py] / maze.getWidth(), visited[px][py] % maze.getWidth()};
                }
                for (int[] p : path) {
                    maze.getMaze()[p[0]][p[1]] = '.';
                }
                maze.getMaze()[maze.getFinishX()][maze.getFinishY()] = 'F';
                return true;
            }

            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] dir : directions) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (nextX >= 0 && nextY >= 0 && nextX < maze.getHeight() && nextY < maze.getWidth()
                    && maze.getMaze()[nextX][nextY] != '#' && visited[nextX][nextY] == -1) {
                    queue.add(new int[] {nextX, nextY});
                    visited[nextX][nextY] = x * maze.getWidth() + y;
                }
            }
        }
        return false;
    }
}
