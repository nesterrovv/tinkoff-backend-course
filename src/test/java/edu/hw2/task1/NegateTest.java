package edu.hw2.task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class NegateTest {

    @Test
    void evaluate_shouldReturnNegatedValueFromPositive() {
        // Arrange
        Expression expression = new Constant(5);
        Negate negate = new Negate(expression);
        // Act
        double result = negate.evaluate();
        // Assert
        assertThat(result).isEqualTo(-5);
    }

    @Test
    void evaluate_shouldReturnNegatedValueFromNegative() {
        // Arrange
        Expression expression = new Constant(-5);
        Negate negate = new Negate(expression);
        // Act
        double result = negate.evaluate();
        // Assert
        assertThat(result).isEqualTo(5);
    }

    @Test
    void evaluate_shouldReturnZero() {
        // Arrange
        Expression expression = new Constant(0);
        Negate negate = new Negate(expression);
        // Act
        double result = negate.evaluate();
        // Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    void evaluate_shouldReturnNegatedValueFromPositiveReal() {
        // Arrange
        Expression expression = new Constant(5.5);
        Negate negate = new Negate(expression);
        // Act
        double result = negate.evaluate();
        // Assert
        assertThat(result).isEqualTo(-5.5);
    }

    @Test
    void evaluate_shouldReturnNegatedValueFromNegativeReal() {
        // Arrange
        Expression expression = new Constant(-5.5);
        Negate negate = new Negate(expression);
        // Act
        double result = negate.evaluate();
        // Assert
        assertThat(result).isEqualTo(5.5);
    }

}
