package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

public class Task7Test {

    private final Task7 task7 = new Task7();

    @ParameterizedTest
    @MethodSource("rotateLeftTestData")
    @DisplayName("Rotate left test")
    void testRotateLeft(int input, int rotations, int expected) {
        // Action
        int result = task7.rotateLeft(input, rotations);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> rotateLeftTestData() {
        // Arrange
        return Stream.of(
            Arguments.of(16, 1, 1),
            Arguments.of(9, 2, 6),
            Arguments.of(17, 2, 6),
            Arguments.of(7, 4, 7),
            Arguments.of(1023, 10, 1023),
            Arguments.of(65535, 100, 65535),
            Arguments.of(2047, 1000, 2047),
            Arguments.of(3, 5, 3),
            Arguments.of(0, 10, 0),
            Arguments.of(0, 100, 0),
            Arguments.of(-10, 10, -1),
            Arguments.of(10, -10, -1),
            Arguments.of(-10, -10, -1)
        );
    }

}

