package edu.hw5.task2;

import edu.exceptions.IncorrectArgumentException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class FridayThe13thSearcher {

    private static final int MONTHS_NUMBER = 12;
    private static final int FOUNDING_DAY = 13;

    private FridayThe13thSearcher() {}

    public static List<String> findFridays13(int year) {
        try {
            if (year <= 0) {
                throw new IncorrectArgumentException("The year must be positive number.");
            }
            List<String> fridays13 = new ArrayList<>();
            for (int month = 1; month <= MONTHS_NUMBER; month++) {
                LocalDate date = LocalDate.of(year, month, FOUNDING_DAY);
                if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                    fridays13.add(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
                }
            }
            return fridays13;
        } catch (IncorrectArgumentException exception) {
            log.error(exception.getMessage());
            log.debug(Arrays.toString(exception.getStackTrace()));
            return Collections.emptyList();
        }
    }

    private static String findNextFriday13(LocalDate currentDate) {
        LocalDate nextFriday13 = currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY))
            .withDayOfMonth(FOUNDING_DAY);
        return nextFriday13.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
