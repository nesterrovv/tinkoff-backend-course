package edu.hw1;

import java.util.logging.Logger;
import java.util.concurrent.*;

public class Task1 {

//    public static void main(String[] args) {
//
//    }

    private final static Logger LOGGER = Logger.getLogger("LOGGER");

    private final static Long secondsInMinute = 60L;

    public long minutesToSeconds(String input) {
        try {
            if (input != null) {
                if (!input.isBlank()) {
                    long totalSecondsNumber = 0L;
                    String[] time = input.split(":", 2);
                    if (time.length == 2) {
                        long minutes = Long.parseLong(time[0]);
                        int seconds = Integer.parseInt(time[1]);
                        if (!(minutes < 0L || seconds < 0 || seconds >= secondsInMinute)) {
                            totalSecondsNumber += minutes * secondsInMinute;
                            totalSecondsNumber += seconds;
                            return totalSecondsNumber;
                        }
                    }
                }
            }
            LOGGER.warning("Input is incorrect.");
            return -1L;
        } catch (NumberFormatException numberFormatException) {
            LOGGER.warning(numberFormatException.getMessage());
            return -1L;
        }
    }

}
