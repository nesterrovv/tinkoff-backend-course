package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public final class DateInWordsParser extends DateParser {

    private static final String TOMORROW = "tomorrow";
    private static final String TODAY = "today";
    private static final String YESTERDAY = "yesterday";

    @Override
    public Optional<LocalDate> parse(String date) {
        try {
            return Optional.of(parseDateInNaturalLanguage(date));
        } catch (Exception e) {
            return parseNext(date);
        }
    }

    public LocalDate parseDateInNaturalLanguage(String date) {
        return switch (date) {
            case YESTERDAY -> getYesterday();
            case TODAY     -> getToday();
            case TOMORROW  -> getTomorrow();
            default        -> throw new IllegalArgumentException();
        };
    }

    private LocalDate getYesterday() {
        return LocalDate.now().minusDays(1);
    }

    private LocalDate getToday() {
        return LocalDate.now();
    }

    private LocalDate getTomorrow() {
        return LocalDate.now().plusDays(1);
    }

}
