package edu.project2.mazes.printer;

import edu.project2.mazes.maze.Cell;
import edu.project2.mazes.maze.Coordinate;
import edu.project2.mazes.maze.Maze;
import edu.project2.mazes.maze.Type;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Printer {

    private static final Logger LOGGER = LogManager.getLogger();

    public void printMaze(Maze maze) {
        LOGGER.info("Generated maze: ");
        Coordinate start = null;
        Coordinate end = null;
        char whiteRectangle = '\u25A0';
        StringBuilder stringBuilder;
        for (int i = 0; i < maze.getHeight(); i++) {
            stringBuilder = new StringBuilder();
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getGrid()[i][j].type() == Type.DOOR) {
                    stringBuilder.append(' ');
                } else if (maze.getGrid()[i][j].type() == Type.WALL) {
                    stringBuilder.append(whiteRectangle);
                } else if (maze.getGrid()[i][j].type() == Type.START) {
                    stringBuilder.append('S');
                    start = maze.getGrid()[i][j].coordinate();
                } else {
                    stringBuilder.append('E');
                    end = maze.getGrid()[i][j].coordinate();
                }
            }
            LOGGER.info(stringBuilder.toString());
        }
    }

    @SuppressWarnings("ParameterAssignment")
    public void printPath(Maze maze, List<Coordinate> path, Coordinate start, Coordinate end) {
        LOGGER.info("Maze with path: ");
        char whiteRectangle = '\u25A0';
        StringBuilder stringBuilder;
        if (path != null) {
            LOGGER.info("Путь найден:");
            for (Coordinate point : path) {
                if (!((point.row() == start.row() && point.col() == start.col())
                    || (point.row() == end.row() && point.col() == end.col()))) {
                    maze.getGrid()[point.row()][point.col()] = new Cell(point, Type.PATH);
                }
            }
            for (int i = 0; i < maze.getHeight(); i++) {
                stringBuilder = new StringBuilder();
                for (int j = 0; j < maze.getWidth(); j++) {
                    if (maze.getGrid()[i][j].type() == Type.DOOR) {
                        stringBuilder.append(' ');
                    } else if (maze.getGrid()[i][j].type() == Type.WALL) {
                        stringBuilder.append(whiteRectangle);
                    } else if (maze.getGrid()[i][j].type() == Type.START) {
                        stringBuilder.append('S');
                        start = maze.getGrid()[i][j].coordinate();
                    } else if (maze.getGrid()[i][j].type() == Type.END) {
                        stringBuilder.append('E');
                        end = maze.getGrid()[i][j].coordinate();
                    } else {
                        stringBuilder.append('+');
                    }
                }
                LOGGER.info(stringBuilder.toString());
            }
        } else {
            LOGGER.warn("Path in this maze not found.");
        }
    }

}
