package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task6Test {

    private final Task6 task6 = new Task6();

    @Test
    @DisplayName("Base test")
    public void testInputWithoutModifying() {
        Assertions.assertEquals(5, task6.countK(6621));
        Assertions.assertEquals(4, task6.countK(6554));
        Assertions.assertEquals(3, task6.countK(1234));
        Assertions.assertEquals(0, task6.countK(6174));
        Assertions.assertEquals(3, task6.countK(3524));
    }

    @Test
    @DisplayName("Test number with 4 equal digits")
    public void testFourEqualDigitsNumberTest() {
        Assertions.assertEquals(-1, task6.countK(1111));
        Assertions.assertEquals(-1, task6.countK(2222));
        Assertions.assertEquals(-1, task6.countK(6666));
    }

    @Test
    @DisplayName("Zero saving necessity input test")
    public void testInputWithZeroSavingNecessity() {
        Assertions.assertEquals(5, task6.countK(1000));
        Assertions.assertEquals(5, task6.countK(9998));
    }

    @Test
    @DisplayName("Incorrect input test")
    public void testIncorrectInput() {
        Assertions.assertEquals(-1, task6.countK(0));
        Assertions.assertEquals(-1, task6.countK(10000));
        Assertions.assertEquals(-1, task6.countK(100));
    }

}
