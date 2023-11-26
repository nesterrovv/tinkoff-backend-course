package edu.hw7.task1;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import static org.assertj.core.api.Assertions.assertThat;

public class MultiThreadCounterTest {

    @Test
    public void testMultithreadCounterOneIncrement() {
        // Arrange
        var count = new MultithreadCounter(0);
        int expected = 1;
        // Act
        count.increment();
        // Assert
        assertThat(count.getValue()).isEqualTo(expected);
    }

    @Test
    public void testMultithreadCounterFewIncrements() {
        // Arrange
        var count = new MultithreadCounter(0);
        int numberOfThreads = Runtime.getRuntime().availableProcessors() - 1;
        int iterationsPerThread = 1_000;
        int expected = numberOfThreads * iterationsPerThread;
        var latch = new CountDownLatch(numberOfThreads);
        // Act
        for (int i = 0; i < numberOfThreads; ++i) {
            new Thread(() -> {
                for (int j = 0; j < iterationsPerThread; ++j) {
                    count.increment();
                }
                latch.countDown();
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        // Assert
        assertThat(count.getValue()).isEqualTo(expected);
    }

}
