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
         |    |\s
         |    \s
         |    \s
         |    \s
        _|_____\s
        """;
        String actualOutput = outputStream.toString();
        // Normalize line endings and remove leading/trailing whitespace
        expectedOutput = expectedOutput.replaceAll("\\r\\n|\\n|\\r", "\n").trim();
        actualOutput = actualOutput.replaceAll("\\r\\n|\\n|\\r", "\n").trim();
        // Assert: use regular expression to compare
        Assertions.assertThat(actualOutput).containsPattern(expectedOutput);
    }


    @Test
    public void shouldDrawGallowsForSecondStage() {
        // Arrange & Act
        GraphicalProcessor.drawGallows(2);
        String expectedOutput = """
         _____\s
         |/   |\s
         |    \s
         |    \s
         |    \s
        _|_____\s
        """;
        String actualOutput = outputStream.toString();
        // Normalize line endings and remove leading/trailing whitespace
        expectedOutput = expectedOutput.replaceAll("\\r\\n|\\n|\\r", "\n").trim();
        actualOutput = actualOutput.replaceAll("\\r\\n|\\n|\\r", "\n").trim();
        // Assert: use regular expression to compare
        Assertions.assertThat(actualOutput).containsPattern(expectedOutput);
    }

    @Test
    public void shouldDrawGallowsForThirdStage() {
        // Arrange & Act
        GraphicalProcessor.drawGallows(3);
        String expectedOutput = """
          ____\s
         |/   |\s
         |    O\s
         |    \s
         |    \s
        _|_____\s
        """;
        String actualOutput = outputStream.toString();
        // Normalize line endings and remove leading/trailing whitespace
        expectedOutput = expectedOutput.replaceAll("\\r\\n|\\n|\\r", "\n").trim();
        actualOutput = actualOutput.replaceAll("\\r\\n|\\n|\\r", "\n").trim();
        // Assert: use regular expression to compare
        Assertions.assertThat(actualOutput).containsPattern(expectedOutput);
    }


    @Test
    public void shouldDrawGallowsForFourthStage() {
        // Arrange & Act
        GraphicalProcessor.drawGallows(4);
        String expectedOutput = """
              ____
             |/   |
             |    O
             |
             |
            _|_______|=|
            """;
        String actualOutput = outputStream.toString();
        // Normalize line endings and remove leading/trailing whitespace
        expectedOutput = expectedOutput.replaceAll("\\r\\n|\\n|\\r", "\n").trim();
        actualOutput = actualOutput.replaceAll("\\r\\n|\\n|\\r", "\n").trim();
        // Assert: use regular expression to compare
        Assertions.assertThat(actualOutput).containsPattern(expectedOutput);
    }

    @Test
    public void shouldDrawGallowsForFifthStage() {
        // Arrange & Act
        GraphicalProcessor.drawGallows(5);
        String expectedOutput = """
          ____
         |/   |
         |    O
         |   /|\\
         |   / \\
        _|_______|=|
        """;
        String actualOutput = outputStream.toString();
        // Normalize line endings and remove leading/trailing whitespace
        expectedOutput = expectedOutput.replaceAll("\\r\\n|\\n|\\r", "\n").trim();
        actualOutput = actualOutput.replaceAll("\\r\\n|\\n|\\r", "\n").trim();
        // Assert: use regular expression to compare
        Assertions.assertThat(actualOutput).containsPattern(expectedOutput);
    }

    @Test
    public void shouldDrawGallowsForInvalidStage() {
        // Arrange & Act
        GraphicalProcessor.drawGallows(6);
        String expectedOutput = "Incorrect stage\n";
        String actualOutput = outputStream.toString();
        // Normalize line endings and remove leading/trailing whitespace
        expectedOutput = expectedOutput.replaceAll("\\r\\n|\\n|\\r", "\n").trim();
        actualOutput = actualOutput.replaceAll("\\r\\n|\\n|\\r", "\n").trim();
        // Assert: use regular expression to compare
        Assertions.assertThat(actualOutput).containsPattern(expectedOutput);
    }

}

