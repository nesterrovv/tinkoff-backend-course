package edu.project1.gallows.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UserInputReaderTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void shouldRejectInvalidCharacter() {
        String input = "1\nx\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        char result = UserInputReader.receiveLetter();
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
