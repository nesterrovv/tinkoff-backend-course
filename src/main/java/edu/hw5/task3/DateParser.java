package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class DateParser {

    private DateParser next;

    public abstract Optional<LocalDate> parse(String date);

    public static DateParser link(DateParser first, DateParser... chain) {
        DateParser head = first;
        for (DateParser nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public Optional<LocalDate> parseNext(String date) {
        if (next == null) {
            return Optional.empty();
        }
        return next.parse(date);
    }

}
