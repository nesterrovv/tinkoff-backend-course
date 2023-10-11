package edu.hw1;

import java.util.logging.Logger;

public class Task1 {

    private final static Logger LOGGER = Logger.getLogger("LOGGER");

    private final static Long SECONDS_IN_MINUTE = 60L;

    public long minutesToSeconds(String input) {
        try {
            if (input != null && !input.isBlank()) {
                long totalSecondsNumber = 0L;
                String[] time = input.split(":", 2);
                long minutes = Long.parseLong(time[0]);
                int seconds = Integer.parseInt(time[1]);
                if (!(minutes < 0L || seconds < 0 || seconds >= SECONDS_IN_MINUTE)) {
                    totalSecondsNumber += minutes * SECONDS_IN_MINUTE;
                    totalSecondsNumber += seconds;
                    return totalSecondsNumber;
                }
            }
            LOGGER.warning("Input is incorrect.");
            return -1L;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
            LOGGER.warning(exception.getMessage());
            return -1L;
        }
    }

}
