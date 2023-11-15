package edu.hw3.task4;

import org.junit.jupiter.api.Test;
import static edu.hw3.task4.IntegerToRomanUtil.ROMAN_MAX_VALUE;
import static edu.hw3.task4.IntegerToRomanUtil.ROMAN_ZERO;
import static edu.hw3.task4.IntegerToRomanUtil.convertToRomanNumber;
import static org.assertj.core.api.Assertions.assertThat;

class IntegerToRomanUtilTest {

    @Test
    void testNegativeNumber() {
        // Arrange
        int number = -1;
        // Act
        String romanNumber = convertToRomanNumber(number);
        // Assert
        assertThat(romanNumber).isEqualTo("Roman numbers cannot be negative.");
    }

    @Test
    void testZero() {
        // Arrange
        int number = 0;
        // Act
        String romanNumber = convertToRomanNumber(number);
        // Assert
        assertThat(romanNumber).isEqualTo(ROMAN_ZERO);
    }

    @Test
    void testNumberFromBounds() {
        // Arrange
        int number = 101;
        // Act
        String romanNumber = convertToRomanNumber(number);
        // Assert
        assertThat(romanNumber).isEqualTo("CI");
    }

    @Test
    void testMaxPossibleValue() {
        // Arrange & Act
        String romanNumber = convertToRomanNumber(ROMAN_MAX_VALUE);
        // Assert
        assertThat(romanNumber).isEqualTo("MMMCMXCIX");
    }

    @Test
    void testNumberGreaterThanMax() {
        // Arrange
        int number = 4000;
        // Act
        String romanNumber = convertToRomanNumber(number);
        // Assert
        assertThat(romanNumber).isEqualTo("Max allowed value is " + ROMAN_MAX_VALUE);
    }

}
