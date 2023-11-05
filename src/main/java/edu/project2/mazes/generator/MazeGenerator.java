package edu.project2.mazes.generator;

import edu.project2.mazes.maze.Cell;
import edu.project2.mazes.maze.Coordinate;
import edu.project2.mazes.maze.Maze;
import edu.project2.mazes.maze.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MazeGenerator implements Generator {
    private final int[] xCoefficients = {-1, 1, 0, 0};
    private final int[] yCoefficients = {0, 0, -1, 1};
    private final int row;
    private final int column;
    private final Random random;

    public MazeGenerator(int row, int col) {
        this.row = row;
        this.column = col;
        random = new Random();
    }

    @Override
    public Maze generateMaze() {
        validateMazeSize();
        Cell[][] cells = initializeGrid();
        Cell startCell = setStartPoint(cells);
        List<int[]> walls = new ArrayList<>();
        walls.add(new int[]{startCell.coordinate().row(), startCell.coordinate().col()});
        generateMazeUsingDFS(cells, walls);
        markEndPoint(cells, startCell);
        return new Maze(row, column, cells);
    }

    private void validateMazeSize() {
        if (row < 4 || row > 10000 || column < 4 || column > 10000) {
            throw new IllegalArgumentException("Enter sizes from 4 to 10000 to generate a maze!");
        }
    }

    private Cell[][] initializeGrid() {
        Cell[][] cells = new Cell[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                cells[i][j] = new Cell(coordinate, Type.WALL);
            }
        }
        return cells;
    }

    private Cell setStartPoint(Cell[][] cells) {
        int startRow = random.nextInt(row);
        int startCol = random.nextInt(column);
        Coordinate start = new Coordinate(startRow, startCol);
        cells[startRow][startCol] = new Cell(start, Type.START);
        return cells[startRow][startCol];
    }

    private void generateMazeUsingDFS(Cell[][] cells, List<int[]> walls) {
        while (!walls.isEmpty()) {
            int randomWallIndex = random.nextInt(walls.size());
            int[] wall = walls.get(randomWallIndex);
            walls.remove(randomWallIndex);
            int wallRow = wall[0];
            int wallCol = wall[1];
            List<Integer> directions = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
            Collections.shuffle(directions, random);
            for (int dir : directions) {
                int newRow = wallRow + 2 * xCoefficients[dir];
                int newCol = wallCol + 2 * yCoefficients[dir];
                if (newRow >= 0 && newRow < row &&
                    newCol >= 0 && newCol < column &&
                    cells[newRow][newCol].type() == Type.WALL) {
                    cells[newRow][newCol] = new Cell(new Coordinate(newRow, newCol), Type.DOOR);
                    cells[wallRow + xCoefficients[dir]][wallCol + yCoefficients[dir]] =
                        new Cell(new Coordinate(
                        wallRow + xCoefficients[dir],
                        wallCol + yCoefficients[dir]), Type.DOOR
                    );
                    walls.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    private void markEndPoint(Cell[][] cells, Cell startCell) {
        do {
            int exitRow = random.nextInt(row);
            int exitCol = random.nextInt(column);
            if (exitRow != startCell.coordinate().row() && exitCol != startCell.coordinate().col() &&
                cells[exitRow][exitCol].type() == Type.DOOR) {
                Coordinate coordinate = new Coordinate(exitRow, exitCol);
                cells[coordinate.row()][coordinate.col()] = new Cell(coordinate, Type.END);
                break;
            }
        } while (true);
    }

}
