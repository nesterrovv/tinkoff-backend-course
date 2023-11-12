package edu.hw2.task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class AdditionTest {

    @Test
    void evaluate_shouldReturnSumOfPositives() {
        // Arrange
        Expression first = new Constant(5);
        Expression second = new Constant(3);
        Addition addition = new Addition(first, second);
        // Act
        double result = addition.evaluate();
        // Assert
        assertThat(result).isEqualTo(5 + 3);
    }

    @Test
    void evaluate_shouldReturnSumOfNegatives() {
        // Arrange
        Expression first = new Constant(-5);
        Expression second = new Constant(-3);
        Addition addition = new Addition(first, second);
        // Act
        double result = addition.evaluate();
        // Assert
        assertThat(result).isEqualTo(-5 + (-3));
    }

    @Test
    void evaluate_shouldReturnSumOfZeroes() {
        // Arrange
        Expression first = new Constant(0);
        Expression second = new Constant(0);
        Addition addition = new Addition(first, second);
        // Act
        double result = addition.evaluate();
        // Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    void evaluate_shouldReturnPositiveSum() {
        // Arrange
        Expression first = new Constant(-3);
        Expression second = new Constant(5);
        Addition addition = new Addition(first, second);
        // Act
        double result = addition.evaluate();
        // Assert
        assertThat(result).isEqualTo(-3 + 5);
    }

    @Test
    void evaluate_shouldReturnNegativeSum() {
        // Arrange
        Expression first = new Constant(-5);
        Expression second = new Constant(3);
        Addition addition = new Addition(first, second);
        // Act
        double result = addition.evaluate();
        // Assert
        assertThat(result).isEqualTo(-5 + 3);
    }

}
