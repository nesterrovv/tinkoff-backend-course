package edu.hw1;

import java.util.logging.Logger;
import java.util.concurrent.*;

public class Task1 {

    private final static Logger logger = Logger.getLogger("HW1_Task1_logger");


    @SuppressWarnings("MagicNumber")
    public long minutesToSeconds(String input) {
        try {
            if (input == null) {
                logger.warning("Input string is null");
                return -1L;
            }
            if (!input.isBlank()) {
                long totalSecondsNumber = 0L;
                String[] time = input.split(":", 2);
                if (time.length < 2) {
                    logger.warning("Incorrect input format. Input is not like a time pattern.");
                    return -1L;
                }
                long minutes = Long.parseLong(time[0]);
                int seconds = Integer.parseInt(time[1]);
                if (minutes < 0L || seconds < 0 || seconds >= 60) {
                    logger.warning("Incorrect input format. Number of minutes/seconds are incorrect.");
                    return -1L;
                }
                totalSecondsNumber += minutes * 60L;
                totalSecondsNumber += seconds;
                return totalSecondsNumber;
            } else {
                logger.warning("Input is empty.");
                return -1L;
            }
        } catch (NumberFormatException numberFormatException) {
            logger.warning(numberFormatException.getMessage());
            return -1L;
        }
    }

}
