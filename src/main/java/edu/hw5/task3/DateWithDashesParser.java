package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public final class DateWithDashesParser extends DateParser {

    private static final String PATTERN = "y-M-d";

    @Override
    public Optional<LocalDate> parse(String date) {
        try {
            return Optional.of(parseDateViaHyphen(date));
        } catch (Exception e) {
            return parseNext(date);
        }
    }

    private LocalDate parseDateViaHyphen(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(PATTERN));
    }

}
