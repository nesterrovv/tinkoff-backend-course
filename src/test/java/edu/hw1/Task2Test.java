package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {

    private final Task2 task2 = new Task2();

    @Test
    @DisplayName("Base inputs test")
    public void testBaseInput() {
        Assertions.assertEquals(4, task2.countNumberOfDigits(1234L));
        Assertions.assertEquals(4, task2.countNumberOfDigits(1111L));
        Assertions.assertEquals(4, task2.countNumberOfDigits(9000L));
    }

    @Test
    @DisplayName("Zeroes input test")
    public void testZeroInput() {
        Assertions.assertEquals(1, task2.countNumberOfDigits(0L));
        Assertions.assertEquals(1, task2.countNumberOfDigits(0000L));
    }

    @Test
    @DisplayName("Big number input test")
    public void testBigNumberInput() {
        Assertions.assertEquals(10, task2.countNumberOfDigits(9_999_999_999L));
        Assertions.assertEquals(10, task2.countNumberOfDigits(9_999_999_990L));
    }

}
