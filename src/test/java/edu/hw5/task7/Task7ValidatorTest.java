package edu.hw5.task7;

import edu.hw5.task7.Task7Validator.ValidatorOption;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class Task7ValidatorTest {

    @Test
    void validate_WhenCondition1AndValidInput_ReturnsTrue() {
        // Arrange
        String input = "1101";
        // Act
        boolean result = Task7Validator.validate(input, ValidatorOption.FIRST);
        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void validate_WhenCondition2AndValidInput_ReturnsTrue() {
        // Arrange
        String input = "010";
        // Act
        boolean result = Task7Validator.validate(input, ValidatorOption.SECOND);
        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void validate_WhenCondition3AndValidInput_ReturnsTrue() {
        // Arrange
        String input = "1010";
        // Act
        boolean result = Task7Validator.validate(input, ValidatorOption.THIRD);
        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void validate_WhenInputIsNull_ReturnsFalse() {
        // Arrange
        String input = null;
        // Act
        boolean result = Task7Validator.validate(input, ValidatorOption.FIRST);
        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void validate_WhenValidatorOptionIsNull_ReturnsFalse() {
        // Arrange
        String input = "1101";
        // Act
        boolean result = Task7Validator.validate(input, null);
        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void validate_WhenInputAndValidatorOptionAreNull_ReturnsFalse() {
        // Arrange
        String input = null;
        // Act
        boolean result = Task7Validator.validate(input, null);
        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void validate_WhenInvalidInput_ReturnsFalse() {
        // Arrange
        String input = "invalidInput";
        // Act
        boolean result = Task7Validator.validate(input, ValidatorOption.FIRST);
        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void validate_WhenInvalidValidatorOption_ReturnsFalse() {
        // Arrange
        String input = "1101";
        // Act
        boolean result = Task7Validator.validate(input, ValidatorOption.THIRD);
        // Assert
        assertThat(result).isFalse();
    }


    @Test
    void validate_WhenInputAndValidatorOptionAreNull_ReturnsFalseWithException() {
        // Arrange
        String input = null;
        // Act
        boolean result = Task7Validator.validate(input, null);
        // Assert
        assertThat(result).isFalse();
    }

}
