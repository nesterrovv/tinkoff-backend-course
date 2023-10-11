package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {

    private final Task6 task6 = new Task6();

    @ParameterizedTest
    @CsvSource({
        "6621, 5",
        "6554, 4",
        "1234, 3",
        "6174, 0",
        "3524, 3"
    })
    void testInputWithoutModifying(int input, int expected) {
        // Arrange & Act
        int result = task6.countK(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "1111, -1",
        "2222, -1",
        "6666, -1"
    })
    void testFourEqualDigitsNumberTest(int input, int expected) {
        // Arrange & Act
        int result = task6.countK(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "1000, 5",
        "9998, 5"
    })
    void testInputWithZeroSavingNecessity(int input, int expected) {
        // Arrange & Act
        int result = task6.countK(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "0, -1",
        "10000, -1",
        "100, -1"
    })
    void testIncorrectInput(int input, int expected) {
        // Arrange & Act
        int result = task6.countK(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

}
