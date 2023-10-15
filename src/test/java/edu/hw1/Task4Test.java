package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    private final Task4 task4 = new Task4();

    @Test
    @DisplayName("Even-length inputs test")
    void testEvenLengthStringInput() {
        // Arrange
        String input = "123456";
        String expected = "214365";
        // Act
        String result = task4.fixString(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Even-length inputs with spaces test")
    void testEvenLengthStringInputWithSpaces() {
        // Arrange
        String input = "2 4163 5";
        String expected = " 214365 ";
        // Act
        String result = task4.fixString(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Mixed up string test")
    void testMixedUpString() {
        // Arrange
        String input = "hTsii  s aimex dpus rtni.g";
        String expected = "This is a mixed up string.";
        // Act
        String result = task4.fixString(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Odd-length inputs test")
    void testOddLengthStringInput() {
        // Arrange
        String input = "badce";
        String expected = "abcde";
        // Act
        String result = task4.fixString(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Odd-length inputs with spaces test")
    void testOddLengthStringInputWithSpaces() {
        // Arrange
        String input = "a cbed ";
        String expected = " abcde ";
        // Act
        String result = task4.fixString(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Reversed input test")
    void testReversedStringInput() {
        // Arrange
        String input = "wqreyti";
        String expected = "qwertyi";
        // Act
        String result = task4.fixString(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Empty input test")
    void testEmptyInput() {
        // Arrange
        String input = "";
        String expected = "";
        // Act
        String result = task4.fixString(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Space input test")
    void testSpaceInput() {
        // Arrange
        String input = " ";
        String expected = " ";
        // Act
        String result = task4.fixString(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Double space input test")
    void testDoubleSpaceInput() {
        // Arrange
        String input = "  ";
        String expected = "  ";
        // Act
        String result = task4.fixString(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Null input test")
    void testNullInput() {
        // Arrange
        String input = null;
        String expected = "";
        // Act
        String result = task4.fixString(input);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

}
