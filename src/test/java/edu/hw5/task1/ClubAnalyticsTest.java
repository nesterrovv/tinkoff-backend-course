package edu.hw5.task1;

import edu.hw5.task1.ClubAnalytics;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ClubAnalyticsTest {

    @Test
    void calculateAverageDuration_ValidInput_ReturnsCorrectResult() {
        // Arrange
        String[] input = {
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        };
        // Act
        String result = ClubAnalytics.calculateAverageDuration(input);
        // Assert
        assertThat(result).isEqualTo("3h 40m");
    }

    @Test
    void calculateAverageDuration_NullInput_ReturnsDefaultResult() {
        // Arrange
        String[] input = null;
        // Act
        String result = ClubAnalytics.calculateAverageDuration(input);
        // Assert
        assertThat(result).isEqualTo("0h 0m");
    }

    @Test
    void calculateAverageDuration_EmptyInput_ReturnsDefaultResult() {
        // Arrange
        String[] input = {};
        // Act
        String result = ClubAnalytics.calculateAverageDuration(input);
        // Assert
        assertThat(result).isEqualTo("0h 0m");
    }

    @Test
    void calculateAverageDuration_InvalidInput_ReturnsDefaultResult() {
        // Arrange
        String[] input = {
            "invalid-date-1",
            "invalid-date-2"
        };
        // Act
        String result = ClubAnalytics.calculateAverageDuration(input);
        // Assert
        assertThat(result).isEqualTo("0h 0m");
    }

}
