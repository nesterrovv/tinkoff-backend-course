package edu.project2.mazes.navigator;

import edu.project2.mazes.maze.Coordinate;
import edu.project2.mazes.maze.Maze;
import java.util.LinkedList;
import java.util.List;

public interface Navigator {
    List<Coordinate> findPath(Maze maze, Coordinate start, Coordinate end);

    default List<Coordinate> receivePath(int[][] initialX, int[][] initialY, Coordinate start, Coordinate end) {
        List<Coordinate> foundPath = new LinkedList<>();
        int x = end.row();
        int y = end.col();
        while (x != start.row() || y != start.col()) {
            foundPath.addFirst(new Coordinate(x, y));
            int tmpX = initialX[x][y];
            int tmpY = initialY[x][y];
            x = tmpX;
            y = tmpY;
        }
        foundPath.addFirst(start);
        return foundPath;
    }

}
