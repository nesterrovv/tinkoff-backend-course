package edu.hw1;

import java.util.logging.Logger;

public class Task2 {

//    public static void main(String[] args) {}

    public int countNumberOfDigits(long number) {
        int counter = 1;
        number /= 10;
        while (number != 0) {
            number /= 10;
            counter++;
        }
        return counter;
    }

}
