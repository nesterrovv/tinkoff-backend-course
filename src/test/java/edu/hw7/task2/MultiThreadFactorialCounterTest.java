package edu.hw7.task2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MultiThreadFactorialCounterTest {

    @Test
    void testFactorial() {
        // Arrange
        int n = 20;
        long expected = 2432902008176640000L;
        // Act
        long result = MultiThreadFactorialCounter.factorial(n);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

}
