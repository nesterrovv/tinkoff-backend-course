package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {

    private final Task4 task4 = new Task4();

    @Test
    @DisplayName("Even-length inputs test")
    public void testEvenLengthStringInput() {
       Assertions.assertEquals("214365", task4.fixString("123456"));
        Assertions.assertEquals(" 214365 ", task4.fixString("2 4163 5"));
       Assertions.assertEquals("This is a mixed up string.", task4.fixString("hTsii  s aimex dpus rtni.g"));
    }

    @Test
    @DisplayName("Odd-length inputs test")
    public void testOddLengthStringInput() {
        Assertions.assertEquals("abcde", task4.fixString("badce"));
        Assertions.assertEquals(" abcde ", task4.fixString("a cbed "));
        Assertions.assertEquals("qwertyi", task4.fixString("wqreyti"));
    }

    @Test
    @DisplayName("Empty input test")
    public void testEmptyInput() {
        Assertions.assertEquals("", task4.fixString(""));
        Assertions.assertEquals(" ", task4.fixString(" "));
        Assertions.assertEquals("  ", task4.fixString("  "));
    }

    @Test
    @DisplayName("Null input test")
    public void testNullInput() {
        Assertions.assertEquals("", task4.fixString(null));
    }

}
