package project2.generator;

import edu.project2.mazes.generator.MazeGenerator;
import edu.project2.mazes.maze.Cell;
import edu.project2.mazes.maze.Maze;
import edu.project2.mazes.maze.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MazeGeneratorTest {

    private int countOccurrencesOfType(Type type, Cell[][] cells) {
        // Arrange
        int counter = 0;
        for (Cell[] cell : cells) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cell[j].type() == type) {
                    counter++;
                }
            }
        }
        return counter;
    }

    @Test
    public void testMazeGenerator() {
        // Arrange
        MazeGenerator generator = new MazeGenerator(5, 6);
        Maze maze = generator.generateMaze();
        // Act
        int cntStart = countOccurrencesOfType(Type.START, maze.getGrid());
        int cntEnd = countOccurrencesOfType(Type.END, maze.getGrid());
        // Assert
        assertThat(maze.getHeight()).isEqualTo(5);
        assertThat(maze.getWidth()).isEqualTo(6);
        assertThat(cntStart).isEqualTo(1);
        assertThat(cntEnd).isEqualTo(1);
    }

    @Test
    public void testIllegalArgumentsWithSmallSize() {
        // Arrange & Act
        MazeGenerator generator = new MazeGenerator(3, 5);
        // Assert
        Assertions.assertThrows(IllegalArgumentException.class, generator::generateMaze);
    }

    @Test
    public void testIllegalArgumentsWithLargeSize() {
        // Arrange & Act
        MazeGenerator generator = new MazeGenerator(11111, 11111);
        // Assert
        Assertions.assertThrows(IllegalArgumentException.class, generator::generateMaze);
    }

}
