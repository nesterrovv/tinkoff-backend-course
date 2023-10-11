package edu.hw1;

public class Task2 {

    private static final Long BASE = 10L;

    public int countNumberOfDigits(long number) {
        long copy = number;
        int counter = 1;
        copy /= BASE;
        while (copy != 0) {
            copy /= BASE;
            counter++;
        }
        return counter;
    }

}
