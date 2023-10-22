package edu.hw2.task3;

import java.util.logging.Logger;

public class FaultyConnection implements Connection {
    private static final Logger LOGGER = Logger.getLogger("LOGGER");

    private final double chanceOfFailure;

    public FaultyConnection(double failureChance) {
        if (failureChance < 0.0 || failureChance > 1.0) {
            throw new IllegalArgumentException();
        }
        this.chanceOfFailure = failureChance;
    }

    @Override
    public void execute(String command) {
        if (Math.random() < chanceOfFailure) {
            LOGGER.severe("Command execution failed.");
            throw new ConnectionException("Failed to execute command");
        }
        LOGGER.info("Command successfully executed.");
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("FaultyConnection closed.");
    }

}
