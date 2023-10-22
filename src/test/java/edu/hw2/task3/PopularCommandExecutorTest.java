package edu.hw2.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PopularCommandExecutorTest {

    @Test
    @DisplayName("Test a faulty connection with chance 100%")
    void testAlwaysFaultyConnection() {
        var connectionManager = new FaultyConnectionManager(1.0);
        int maxAttempts = 10;
        PopularCommandExecutor executor = new PopularCommandExecutor(connectionManager, maxAttempts);
        assertThrows(ConnectionException.class, executor::executeCommand);
    }

    @Test
    @DisplayName("Test stable connection")
    void testAlwaysStableConnection() {
        var connectionManager = new DefaultConnectionManager(0.0, 0.0);
        int maxAttempts = 10;
        PopularCommandExecutor executor = new PopularCommandExecutor(connectionManager, maxAttempts);
        assertDoesNotThrow(executor::executeCommand);
    }

    @Test
    @DisplayName("Test connection manager with stable connection")
    void testDefaultConnectionManagerWithStableConnection() {
        var alwaysSuccessfully = new DefaultConnectionManager(0.0, 0.0);
        assertThat(alwaysSuccessfully.getConnection()).isInstanceOf(StableConnection.class);
    }

    @Test
    @DisplayName("Test connection manager with faulty connection")
    void testDefaultConnectionManagerWithFaultyConnection() {
        var alwaysFailure = new DefaultConnectionManager(1.0, 0.0);

        assertThat(alwaysFailure.getConnection()).isInstanceOf(FaultyConnection.class);
    }

}
