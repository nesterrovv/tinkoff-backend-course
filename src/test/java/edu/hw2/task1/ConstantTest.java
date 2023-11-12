package edu.hw2.task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ConstantTest {

    @Test
    void evaluate_shouldReturnPositive() {
        // Arrange
        Constant constant = new Constant(5);
        // Act
        double result = constant.evaluate();
        // Assert
        assertThat(result).isEqualTo(5);
    }

    @Test
    void evaluate_shouldReturnNegative() {
        // Arrange
        Constant constant = new Constant(-5);
        // Act
        double result = constant.evaluate();
        // Assert
        assertThat(result).isEqualTo(-5);
    }

    @Test
    void evaluate_shouldReturnZero() {
        // Arrange
        Constant constant = new Constant(0);
        // Act
        double result = constant.evaluate();
        // Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    void evaluate_shouldReturnPositiveReal() {
        // Arrange
        Constant constant = new Constant(5.5);
        // Act
        double result = constant.evaluate();
        // Assert
        assertThat(result).isEqualTo(5.5);
    }

    @Test
    void evaluate_shouldReturnNegativeReal() {
        // Arrange
        Constant constant = new Constant(-5.5);
        // Act
        double result = constant.evaluate();
        // Assert
        assertThat(result).isEqualTo(-5.5);
    }

}
