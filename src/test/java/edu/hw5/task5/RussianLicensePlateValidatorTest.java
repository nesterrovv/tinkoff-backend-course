package edu.hw5.task5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RussianLicensePlateValidatorTest {

    @Test
    void isValidLicensePlate_WhenValidLicensePlate_ReturnsTrue() {
        // Arrange
        String validPlate = "А123ВЕ777";
        // Act
        boolean isValid = RussianLicensePlateValidator.isValidLicensePlate(validPlate);
        // Assert
        assertThat(isValid).isTrue();
    }

    @Test
    void isValidLicensePlate_WhenInvalidLicensePlate_ReturnsFalse() {
        // Arrange
        String invalidPlate = "123АВЕ777";
        // Act
        boolean isValid = RussianLicensePlateValidator.isValidLicensePlate(invalidPlate);
        // Assert
        assertThat(isValid).isFalse();
    }

    @Test
    void isValidLicensePlate_WhenNullLicensePlate_ReturnsFalse() {
        // Arrange
        String nullPlate = null;
        // Act
        boolean isValid = RussianLicensePlateValidator.isValidLicensePlate(nullPlate);
        // Assert
        assertThat(isValid).isFalse();
    }

    @Test
    void isValidLicensePlate_WhenEmptyLicensePlate_ReturnsFalse() {
        // Arrange
        String emptyPlate = "";
        // Act
        boolean isValid = RussianLicensePlateValidator.isValidLicensePlate(emptyPlate);
        // Assert
        assertThat(isValid).isFalse();
    }
}
