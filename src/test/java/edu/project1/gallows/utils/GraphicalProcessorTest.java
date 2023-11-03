package edu.project1.gallows.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GraphicalProcessorTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void arrange() {
        // Arrange
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldDrawGallowsForFirstStage() {
        // Arrange & Act
        GraphicalProcessor.drawGallows(1);
        String expectedOutput = """
             _____\s
             |    |
             |    \s
             |    \s
             |    \s
            _|_____
            """;
        String actualOutput = outputStream.toString();
        expectedOutput = expectedOutput.replace("\r\n", "\n");
        actualOutput = actualOutput.replace("\r\n", "\n");
        // Assert
        Assertions.assertThat(expectedOutput).isEqualTo(actualOutput);
    }

    @Test
    public void shouldDrawGallowsForSecondStage() {
        // Arrange & Act
        GraphicalProcessor.drawGallows(2);
        String expectedOutput = """
             _____\s
             |/   |
             |    \s
             |    \s
             |    \s
            _|_____
            """;
        String actualOutput = outputStream.toString();
        expectedOutput = expectedOutput.replace("\r\n", "\n");
        actualOutput = actualOutput.replace("\r\n", "\n");
        // Assert
        Assertions.assertThat(expectedOutput).isEqualTo(actualOutput);
    }

    @Test
    public void shouldDrawGallowsForThirdStage() {
        // Arrange & Act
        GraphicalProcessor.drawGallows(3);
        String expectedOutput = """
              ____\s
             |/   |
             |    O
             |    \s
             |    \s
            _|_____
            """;
        String actualOutput = outputStream.toString();
        expectedOutput = expectedOutput.replace("\r\n", "\n");
        actualOutput = actualOutput.replace("\r\n", "\n");
        // Assert
        Assertions.assertThat(expectedOutput).isEqualTo(actualOutput);
    }

    @Test
    public void shouldDrawGallowsForFourthStage() {
        // Arrange & Act
        GraphicalProcessor.drawGallows(4);
        String expectedOutput = """
              ____\s
             |/   |
             |    O
             |    \s
             |    \s
            _|_______|=|
            """;
        String actualOutput = outputStream.toString();
        expectedOutput = expectedOutput.replace("\r\n", "\n");
        actualOutput = actualOutput.replace("\r\n", "\n");
        // Assert
        Assertions.assertThat(expectedOutput).isEqualTo(actualOutput);
    }

    @Test
    public void shouldDrawGallowsForFifthStage() {
        // Arrange & Act
        GraphicalProcessor.drawGallows(5);
        String expectedOutput = """
              ____\s
             |/   |
             |    O
             |   /|\\
             |   / \\
            _|_______|=|
            """;
        String actualOutput = outputStream.toString();
        expectedOutput = expectedOutput.replace("\r\n", "\n");
        actualOutput = actualOutput.replace("\r\n", "\n");
        // Assert
        Assertions.assertThat(expectedOutput).isEqualTo(actualOutput);
    }

    @Test
    public void shouldDrawGallowsForInvalidStage() {
        // Arrange & Act
        GraphicalProcessor.drawGallows(6);
        String expectedOutput = "Incorrect stage\n";
        String actualOutput = outputStream.toString();
        expectedOutput = expectedOutput.replace("\r\n", "\n");
        actualOutput = actualOutput.replace("\r\n", "\n");
        // Assert
        Assertions.assertThat(expectedOutput).isEqualTo(actualOutput);
    }

}

