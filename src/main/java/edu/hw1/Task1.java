package edu.hw1;

import java.util.logging.Logger;

public class Task1 {

    private final static Logger logger = Logger.getLogger("HW1 Task1 logger");

    public static void main(String[] args) {
//        System.out.println(minutesToSeconds("01:00"));
//        System.out.println(minutesToSeconds("13:56"));
//        System.out.println(minutesToSeconds("14:59"));
//        System.out.println(minutesToSeconds("01:10"));
//        System.out.println(minutesToSeconds("10:01"));
//        System.out.println(minutesToSeconds("00:01"));
//        System.out.println(minutesToSeconds("01:00"));
//        System.out.println(minutesToSeconds("00:00"));
//        System.out.println(minutesToSeconds("3000000000:59"));
//        System.out.println(minutesToSeconds("10:60"));
//        System.out.println(minutesToSeconds("10:99"));
//        System.out.println(minutesToSeconds("-10:30"));
//        System.out.println(minutesToSeconds("10:-30"));
//        System.out.println(minutesToSeconds("-10:-30"));
//        System.out.println(minutesToSeconds("1099"));
//        System.out.println(minutesToSeconds("abc"));
//        System.out.println(minutesToSeconds("abc:abc"));
//        System.out.println(minutesToSeconds(""));
//        System.out.println(minutesToSeconds(null));
    }

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
                    logger.warning("Incorrect input format");
                    return -1L;
                }
                long minutes = Long.parseLong(time[0]);
                int seconds = Integer.parseInt(time[1]);
                if (minutes < 0L || seconds < 0 || seconds >= 60) {
                    logger.warning("Incorrect input format");
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
