package edu.hw7.task2;

import java.util.stream.LongStream;

public final class SingleThreadFactorialCalculator {

    private SingleThreadFactorialCalculator() {}

    private static final int MAXIMUM = 20;

    public static long factorial(int n) {
        if (n < 0 || n > MAXIMUM) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return 1L;
        }
        return LongStream
            .rangeClosed(1, n)
            .reduce(1L, (long a, long b) -> a * b);
    }

}
