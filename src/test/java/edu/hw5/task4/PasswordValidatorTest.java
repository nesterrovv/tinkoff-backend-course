package edu.hw5.task4;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void isValidPassword_WhenPasswordContainsSpecialCharacter_ReturnsTrue() {
        // Arrange
        String password = "securePassword!";
        // Act
        boolean isValid = PasswordValidator.isValidPassword(password);
        // Assert
        assertThat(isValid).isTrue();
    }

    @Test
    void isValidPassword_WhenPasswordDoesNotContainSpecialCharacter_ReturnsFalse() {
        // Arrange
        String password = "weakPassword";
        // Act
        boolean isValid = PasswordValidator.isValidPassword(password);
        // Assert
        assertThat(isValid).isFalse();
    }

    @Test
    void isValidPassword_WhenPasswordIsNull_ReturnsFalse() {
        // Arrange
        String password = null;
        // Act
        boolean isValid = PasswordValidator.isValidPassword(password);
        // Assert
        assertThat(isValid).isFalse();
    }

    @Test
    void isValidPassword_WhenPasswordIsEmpty_ReturnsFalse() {
        // Arrange
        String password = "";
        // Act
        boolean isValid = PasswordValidator.isValidPassword(password);
        // Assert
        assertThat(isValid).isFalse();
    }

}
