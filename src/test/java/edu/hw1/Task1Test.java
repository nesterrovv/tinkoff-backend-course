package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    private final Task1 task1 = new Task1();

    @ParameterizedTest
    @CsvSource({
        "13:56, 836",
        "14:59, 899"
    })
    void testBaseInput(String input, long expected) {
        // Arrange & Act
        long result = task1.minutesToSeconds(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "01:10, 70",
        "10:01, 601",
        "00:01, 1",
        "01:00, 60",
        "00:00, 0"
    })
    void testInputWithZeroes(String input, long expected) {
        // Arrange & Act
        long result = task1.minutesToSeconds(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "3000000000:01, 180000000001"
    })
    void testBigNumberInput(String input, long expected) {
        // Arrange & Act
        long result = task1.minutesToSeconds(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "10:60, -1",
        "10:99, -1",
        "-10:30, -1",
        "10:-30, -1",
        "-10:-30, -1"
    })
    void testIncorrectNumberInput(String input, long expected) {
        // Arrange & Act
        long result = task1.minutesToSeconds(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "1099, -1",
        "abc, -1",
        "abc:abc, -1",
        ", -1"
    })
    void testIncorrectInput(String input, long expected) {
        // Arrange & Act
        long result = task1.minutesToSeconds(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        ", -1"
    })
    void testEmptyInput(String input, long expected) {
        // Arrange & Act
        long result = task1.minutesToSeconds(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "null, -1"
    })
    void testNullInput(String input, long expected) {
        // Arrange & Act
        long result = task1.minutesToSeconds(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

}
