package edu.hw7.task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SingleThreadCounterTest {

    @Test
    void testSingleThreadCounterIncrement() {
        // Arrange
        var count = new SingleThreadCounter(0);
        int expected = 1;
        // Act
        count.increment();
        // Assert
        assertThat(count.getValue()).isEqualTo(expected);
    }

}
