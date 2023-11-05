package project2.navigator;

import edu.project2.mazes.maze.Cell;
import edu.project2.mazes.maze.Coordinate;
import edu.project2.mazes.maze.Maze;
import edu.project2.mazes.maze.Type;
import edu.project2.mazes.navigator.MazeNavigatorBFS;
import edu.project2.mazes.navigator.MazeNavigatorDFS;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NavigatorTest {

    Maze maze;
    Cell[][] cells;
    MazeNavigatorBFS mazeNavigatorBFS;
    MazeNavigatorDFS mazeNavigatorDFS;

    @BeforeEach
    public void createMaze() {
        // Arrange
        cells = new Cell[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cells[i][j] = new Cell(new Coordinate(i, j), Type.DOOR);
            }
        }
        cells[0][0] = new Cell(new Coordinate(0, 0), Type.WALL);
        cells[0][1] = new Cell(new Coordinate(0, 1), Type.START);
        cells[0][2] = new Cell(new Coordinate(0, 2), Type.WALL);
        cells[0][3] = new Cell(new Coordinate(0, 3), Type.WALL);
        cells[0][4] = new Cell(new Coordinate(0, 4), Type.WALL);
        cells[1][2] = new Cell(new Coordinate(1, 2), Type.WALL);
        cells[2][2] = new Cell(new Coordinate(2, 2), Type.WALL);
        cells[2][0] = new Cell(new Coordinate(2, 0), Type.WALL);
        cells[3][4] = new Cell(new Coordinate(3, 4), Type.WALL);
        cells[4][1] = new Cell(new Coordinate(4, 1), Type.WALL);
        cells[4][3] = new Cell(new Coordinate(4, 3), Type.WALL);
        mazeNavigatorBFS = new MazeNavigatorBFS();
        mazeNavigatorDFS = new MazeNavigatorDFS();
        maze = new Maze(5, 5, cells);
    }

    @Test
    public void testBFSNavigator() {
        // Arrange
        List<Coordinate> expected = new LinkedList<>(List.of(
            new Coordinate(0, 1),
            new Coordinate(1, 1),
            new Coordinate(2, 1),
            new Coordinate(3, 1),
            new Coordinate(3, 2),
            new Coordinate(3, 3),
            new Coordinate(2, 3),
            new Coordinate(2, 4))
        );
        // Act
        List<Coordinate> response = mazeNavigatorBFS.findPath(
            maze, new Coordinate(0, 1), new Coordinate(2, 4));
        // Assert
        assertThat(response.size()).isEqualTo(expected.size());
        assertThat(response).isEqualTo(expected);
    }

    @Test
    public void testDFSNavigator() {
        // Arrange
        List<Coordinate> expected = new LinkedList<>(List.of(
            new Coordinate(0, 1),
            new Coordinate(1, 1),
            new Coordinate(2, 1),
            new Coordinate(3, 1),
            new Coordinate(3, 2),
            new Coordinate(3, 3),
            new Coordinate(2, 3),
            new Coordinate(2, 4))
        );
        // Act
        List<Coordinate> response = mazeNavigatorDFS.findPath(
            maze, new Coordinate(0, 1), new Coordinate(2, 4));
        assertThat(response.size()).isEqualTo(expected.size());
        // Assert
        assertThat(response).isEqualTo(expected);
    }

    @Test
    public void testBFSNavigatorWithNotReachableEndPoint() {
        // Arrange & Act
        List<Coordinate> response = mazeNavigatorBFS.findPath(
            maze, new Coordinate(0, 1), new Coordinate(4, 4));
        // Assert
        assertNull(response);
    }

    @Test
    public void testDFSNavigatorWithNotReachableEndPoint() {
        List<Coordinate> response = mazeNavigatorDFS.findPath(
            maze, new Coordinate(0, 1), new Coordinate(4, 4));
        assertNull(response);
    }

}
