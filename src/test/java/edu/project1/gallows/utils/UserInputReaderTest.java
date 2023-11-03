package edu.project1.gallows.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class UserInputReaderTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void arrange() {
        // Arrange
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void cleanup() {
        // Cleanup
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void shouldRejectInvalidCharacter() {
        // Arrange
        String input = "1\nx\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // Act
        char result = UserInputReader.receiveLetter();
        // Assert
        Assertions.assertThat(result).isEqualTo('x');
        String expectedOutput = """
        Input letter:
        That's not letter. Try again.
        Input letter:
        """;
        Assertions.assertThat(outputStream.toString().replace("\r\n", "\n"))
            .isEqualTo(expectedOutput.replace("\r\n", "\n"));
    }

}
