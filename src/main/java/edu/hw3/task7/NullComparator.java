package edu.hw3.task7;

import java.util.Comparator;

public class NullComparator<T extends Comparable<T>> implements Comparator<T> {

    @Override
    public int compare(T first, T second) {
        if (first == null && second == null) {
            return 0;
        }
        if (first == null) {
            return -1;
        }
        if (second == null) {
            return 1;
        }
        return first.compareTo(second);
    }

}
