package edu.project2.mazes.navigator;

import edu.project2.mazes.maze.Cell;
import edu.project2.mazes.maze.Coordinate;
import edu.project2.mazes.maze.Maze;
import edu.project2.mazes.maze.Type;
import java.util.List;
import java.util.Stack;

public class MazeNavigatorDFS implements Navigator {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static boolean isValidMaze(int x, int y, Cell[][] maze) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && !(maze[x][y].type() == Type.WALL);
    }

    @Override
    public List<Coordinate> findPath(Maze maze1, Coordinate start, Coordinate end) {
        Cell[][] maze = maze1.getGrid();
        int m = maze1.getWidth();
        int n = maze1.getHeight();
        boolean[][] visited = new boolean[m][n];
        int[][] parentX = new int[m][n];
        int[][] parentY = new int[m][n];
        Stack<Coordinate> stack = new Stack<>();
        stack.push(start);
        visited[start.row()][start.col()] = true;

        while (!stack.isEmpty()) {
            Coordinate current = stack.pop();
            if (current.row() == end.row() && current.col() == end.col()) {
                return receivePath(parentX, parentY, start, end);
            }

            for (int[] dir : DIRECTIONS) {
                int newX = current.row() + dir[0];
                int newY = current.col() + dir[1];
                if (isValidMaze(newX, newY, maze) && !visited[newX][newY]) {
                    stack.push(new Coordinate(newX, newY));
                    visited[newX][newY] = true;
                    parentX[newX][newY] = current.row();
                    parentY[newX][newY] = current.col();
                }
            }
        }

        return null;
    }
}
