package edu.hw5.task1;

import edu.exceptions.IncorrectArgumentException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class ClubAnalytics {

    private ClubAnalytics() {}

    public static String calculateAverageDuration(String[] input) {
        try {
            if (input == null) {
                throw new IncorrectArgumentException("Given array of time segments can`t be null.");
            }
            if (input.length == 0) {
                throw new IncorrectArgumentException("Given array of time segments can`t be empty.");
            }
            long totalDurationSeconds = 0;
            int count = 0;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
            for (String line : input) {
                String[] parts = line.split(" - ");
                LocalDateTime startTime = LocalDateTime.parse(parts[0], formatter);
                LocalDateTime endTime = LocalDateTime.parse(parts[1], formatter);
                Duration duration = Duration.between(startTime, endTime);
                totalDurationSeconds += duration.getSeconds();
                count++;
            }
            long averageDurationSeconds = totalDurationSeconds / count;
            Duration averageDuration = Duration.ofSeconds(averageDurationSeconds);
            long hours = averageDuration.toHours();
            long minutes = averageDuration.toMinutesPart();
            return hours + "h " + minutes + "m";
        } catch (IncorrectArgumentException | DateTimeParseException exception) {
            log.error(exception.getMessage());
            log.debug(Arrays.toString(exception.getStackTrace()));
            return "0h 0m"; // in these cases, there are no time spent in the club
        }
    }

}
