package edu.hw5.task8;

import edu.hw5.task8.Task8Validator.ValidatorOption;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class Task8ValidatorTest {

    @Test
    void validate_FirstCondition_ValidInput_ReturnsTrue() {
        // Arrange
        String input = "101";
        // Act
        boolean result = Task8Validator.validate(input, ValidatorOption.FIRST);
        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void validate_SecondCondition_ValidInput_ReturnsTrue() {
        // Arrange
        String input = "010";
        // Act
        boolean result = Task8Validator.validate(input, ValidatorOption.SECOND);
        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void validate_ThirdCondition_ValidInput_ReturnsFalse() {
        // Arrange
        String input = "0101010";
        // Act
        boolean result = Task8Validator.validate(input, ValidatorOption.THIRD);
        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void validate_FourthCondition_ValidInput_ReturnsTrue() {
        // Arrange
        String input = "010101";
        // Act
        boolean result = Task8Validator.validate(input, ValidatorOption.FOURTH);
        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void validate_FifthCondition_ValidInput_ReturnsTrue() {
        // Arrange
        String input = "10101";
        // Act
        boolean result = Task8Validator.validate(input, ValidatorOption.FIFTH);
        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void validate_SixthCondition_ValidInput_ReturnsTrue() {
        // Arrange
        String input = "0010";
        // Act
        boolean result = Task8Validator.validate(input, ValidatorOption.SIXTH);
        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void validate_SeventhCondition_ValidInput_ReturnsTrue() {
        // Arrange
        String input = "0101010";
        // Act
        boolean result = Task8Validator.validate(input, ValidatorOption.SEVENTH);
        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void validate_SecondCondition_InvalidInput_ReturnsFalse() {
        // Arrange
        String input = "111";
        // Act
        boolean result = Task8Validator.validate(input, ValidatorOption.SECOND);
        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void validate_WithNullInput_ReturnsFalse() {
        // Arrange
        String input = null;
        // Act
        boolean result = Task8Validator.validate(input, ValidatorOption.THIRD);
        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void validate_WithNullOption_ReturnsFalse() {
        // Arrange
        String input = "0101";
        // Act
        boolean result = Task8Validator.validate(input, null);
        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void validate_WithNullInputAndNullOption_ReturnsFalse() {
        // Arrange
        String input = null;
        // Act
        boolean result = Task8Validator.validate(input, null);
        // Assert
        assertThat(result).isFalse();
    }

}
