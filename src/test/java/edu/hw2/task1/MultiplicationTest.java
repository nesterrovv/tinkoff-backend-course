package edu.hw2.task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class MultiplicationTest {

    @Test
    void evaluate_shouldReturnMultiplicationOfPositives() {
        // Arrange
        Expression first = new Constant(5);
        Expression second = new Constant(3);
        Multiplication multiplication = new Multiplication(first, second);
        // Act
        double result = multiplication.evaluate();
        // Assert
        assertThat(result).isEqualTo(5 * 3);
    }

    @Test
    void evaluate_shouldReturnMultiplicationOfNegatives() {
        // Arrange
        Expression first = new Constant(-5);
        Expression second = new Constant(-3);
        Multiplication multiplication = new Multiplication(first, second);
        // Act
        double result = multiplication.evaluate();
        // Assert
        assertThat(result).isEqualTo(-5 * (-3));
    }

    @Test
    void evaluate_shouldReturnMultiplicationOfZeroes() {
        // Arrange
        Expression first = new Constant(0);
        Expression second = new Constant(0);
        Multiplication multiplication = new Multiplication(first, second);
        // Act
        double result = multiplication.evaluate();
        // Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    void evaluate_shouldReturnMultiplicationForDiffSigns() {
        // Arrange
        Expression first = new Constant(-3);
        Expression second = new Constant(5);
        Multiplication multiplication = new Multiplication(first, second);
        // Act
        double result = multiplication.evaluate();
        // Assert
        assertThat(result).isEqualTo(-3 * 5);
    }

}
