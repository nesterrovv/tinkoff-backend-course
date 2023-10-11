package edu.hw1;

import java.util.Arrays;
import java.util.logging.Logger;

public class Task3 {

    private static final Logger LOGGER = Logger.getLogger("LOGGER");

    public boolean isNestable(int[] first, int[] second) {
        if (first == null || second == null || first.length == 0 || second.length == 0) {
            return false;
        } else {
            return findMinimum(first) > findMinimum(second) && findMaximum(first) < findMaximum(second);
        }
    }

    private int findMaximum(int[] array) {
        var value = Arrays.stream(array).max();
        if (value.isPresent()) {
            return value.getAsInt();
        } else {
            LOGGER.warning("Cannot find maximum");
            return Integer.MIN_VALUE;
        }
    }

    private int findMinimum(int[] array) {
        var value = Arrays.stream(array).min();
        if (value.isPresent()) {
            return value.getAsInt();
        } else {
            LOGGER.warning("Cannot find minimum");
            return Integer.MIN_VALUE;
        }
    }
}
