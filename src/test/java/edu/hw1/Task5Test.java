package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    private final Task5 task5 = new Task5();

    @ParameterizedTest
    @CsvSource({
        "1, true",
        "11, true",
        "121, true",
        "1221, true"
    })
    void testInputWithoutModifying(long input, boolean expected) {
        // Arrange & Act
        boolean result = task5.isPalindromeDescendant(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "1, true",
        "12, false",
        "123, true",
        "121, true",
        "31213, true",
        "4123214, true"
    })
    void testInputWithModifying(long input, boolean expected) {
        // Arrange & act
        boolean result = task5.isPalindromeDescendant(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

}
