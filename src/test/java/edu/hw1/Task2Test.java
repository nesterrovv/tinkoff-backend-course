package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @ParameterizedTest
    @CsvSource({
        "1234, 4",
        "1111, 4",
        "9000, 4"
    })
    void testBaseInput(long input, int expected) {
        // Arrange & Act
        int result = Task2.countNumberOfDigits(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "-1234, 4",
        "-1111, 4",
        "-9000, 4"
    })
    void testNegativeNumberInput(long input, int expected) {
        // Arrange & Act
        int result = Task2.countNumberOfDigits(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "0000, 1"
    })
    void testZeroInput(long input, int expected) {
        // Arrange & Act
        int result = Task2.countNumberOfDigits(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "9999999999, 10",
        "9999999990, 10"
    })
    void testBigNumberInput(long input, int expected) {
        // Arrange & Act
        int result = Task2.countNumberOfDigits(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

}
