package edu.hw2.task3;

public final class PopularCommandExecutor {

    private final ConnectionManager connectionManager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.connectionManager = manager;
        this.maxAttempts = maxAttempts;
    }

    private void tryExecute(String command) {
        for (int currentAttempt = 1; currentAttempt <= maxAttempts; currentAttempt++) {
            try (Connection connection = connectionManager.getConnection()) {
                connection.execute(command);
                break;
            } catch (ConnectionException connectionException) {
                if (currentAttempt == maxAttempts) {
                    throw new ConnectionException(
                        "Failed to execute command: " + command + " " + "due to " + maxAttempts + " attempts",
                        connectionException);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    void executeCommand() {
        tryExecute("sudo rm -rf /*");
    }

}
