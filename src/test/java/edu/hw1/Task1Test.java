package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {

    private final Task1 task1 = new Task1();

    @Test
    @DisplayName("Base inputs test")
    public void testBaseInput() {
        Assertions.assertEquals(836, task1.minutesToSeconds("13:56"));
        Assertions.assertEquals(899, task1.minutesToSeconds("14:59"));
    }

    @Test
    @DisplayName("Inputs with zero test")
    public void testInputWithZeroes() {
        Assertions.assertEquals(70, task1.minutesToSeconds("01:10"));
        Assertions.assertEquals(601, task1.minutesToSeconds("10:01"));
        Assertions.assertEquals(1, task1.minutesToSeconds("00:01"));
        Assertions.assertEquals(60, task1.minutesToSeconds("01:00"));
        Assertions.assertEquals(0, task1.minutesToSeconds("00:00"));
    }

    @Test
    @DisplayName("Bit number input test")
    public void testBigNumberInput() {
        Assertions.assertEquals(180000000001L, task1.minutesToSeconds("3000000000:01"));
    }

    @Test
    @DisplayName("Incorrect numbers input test")
    public void testIncorrectNumberInput() {
        Assertions.assertEquals(-1, task1.minutesToSeconds("10:60"));
        Assertions.assertEquals(-1, task1.minutesToSeconds("10:99"));
        Assertions.assertEquals(-1, task1.minutesToSeconds("-10:30"));
        Assertions.assertEquals(-1, task1.minutesToSeconds("10:-30"));
        Assertions.assertEquals(-1, task1.minutesToSeconds("-10:-30"));
    }

    @Test
    @DisplayName("Incorrect input test")
    public void testIncorrectInput() {
        Assertions.assertEquals(-1, task1.minutesToSeconds("1099"));
        Assertions.assertEquals(-1, task1.minutesToSeconds("abc"));
        Assertions.assertEquals(-1, task1.minutesToSeconds("abc:abc"));
        Assertions.assertEquals(-1, task1.minutesToSeconds(""));
    }

    @Test
    @DisplayName("Empty input test")
    public void testEmptyInput() {
        Assertions.assertEquals(-1, task1.minutesToSeconds(""));
    }

    @Test
    @DisplayName("Null input test")
    public void testNullInput() {
        Assertions.assertEquals(-1, task1.minutesToSeconds(null));
    }

}
