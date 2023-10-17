package edu.hw2.task1;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ExponentTest {

    @Test
    void evaluate_positiveToPositivePower() {
        // Arrange
        Expression base = new Constant(2);
        int power = 3;
        Exponent exponent = new Exponent(base, power);
        // Act
        double result = exponent.evaluate();
        // Assert
        assertThat(result).isEqualTo(8); // 2^3 = 8
    }

    @Test
    void evaluate_positiveToNegativeEvenPower() {
        // Arrange
        Expression base = new Constant(3);
        int power = -2;
        Exponent exponent = new Exponent(base, power);
        // Act
        double result = exponent.evaluate();
        // Assert
        assertThat(result).isEqualTo(1.0 / 9); // 3^(-2) = 1/9
    }

    @Test
    void evaluate_positiveToNegativeOddPower() {
        // Arrange
        Expression base = new Constant(2);
        int power = -3;
        Exponent exponent = new Exponent(base, power);
        // Act
        double result = exponent.evaluate();
        // Assert
        assertThat(result).isEqualTo(0.125); // 2^(-3) = 1/8 = 0.125
    }

    @Test
    void evaluate_negativeToNegativeEvenPower() {
        // Arrange
        Expression base = new Constant(-2);
        int power = -2;
        Exponent exponent = new Exponent(base, power);
        // Act
        double result = exponent.evaluate();
        // Assert
        assertThat(result).isEqualTo(0.25);
    }

    @Test
    void evaluate_negativeToNegativeOddPower() {
        // Arrange
        Expression base = new Constant(-3);
        int power = -3;
        Exponent exponent = new Exponent(base, power);
        // Act
        double result = exponent.evaluate();
        // Assert with precision
        assertThat(result).isCloseTo(-0.037037, Offset.offset(0.0001)); // (-3)^(-3) = -1/27 ≈ -0.037037
    }

    @Test
    void evaluate_positiveToZeroPower() {
        // Arrange
        Expression base = new Constant(4);
        int power = 0;
        Exponent exponent = new Exponent(base, power);
        // Act
        double result = exponent.evaluate();
        // Assert
        assertThat(result).isEqualTo(1); // 4^0 = 1
    }

    @Test
    void evaluate_negativeToZeroPower() {
        // Arrange
        Expression base = new Constant(-5);
        int power = 0;
        Exponent exponent = new Exponent(base, power);
        // Act
        double result = exponent.evaluate();
        // Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    void evaluate_positiveDecimalToPositivePower() {
        // Arrange
        Expression base = new Constant(2.5);
        int power = 2;
        Exponent exponent = new Exponent(base, power);
        // Act
        double result = exponent.evaluate();
        // Assert
        assertThat(result).isEqualTo(6.25); // 2.5^2 = 6.25
    }

    @Test
    void evaluate_positiveDecimalToNegativeOddPowerWithPrecision() {
        // Arrange
        Expression base = new Constant(1.5);
        int power = -3;
        Exponent exponent = new Exponent(base, power);
        // Act
        double result = exponent.evaluate();
        // Assert with precision
        assertThat(result).isCloseTo(0.296296, Offset.offset(0.0001));
    }

}
