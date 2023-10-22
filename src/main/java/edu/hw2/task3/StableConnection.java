package edu.hw2.task3;

import java.util.logging.Logger;

public class StableConnection implements Connection {
    private static final Logger LOGGER = Logger.getLogger("LOGGER");

    @Override
    public void execute(String command) {
        LOGGER.info("Command successfully executed.");
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("StableConnection closed.");
    }

}
