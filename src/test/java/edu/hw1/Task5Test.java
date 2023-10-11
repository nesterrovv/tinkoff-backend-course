package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task5Test {

    private final Task5 task5 = new Task5();

    @Test
    @DisplayName("Input without modifying test")
    public void testInputWithoutModifying() {
        Assertions.assertTrue(task5.isPalindromeDescendant(1L));
        Assertions.assertTrue(task5.isPalindromeDescendant(11L));
        Assertions.assertTrue(task5.isPalindromeDescendant(121L));
        Assertions.assertTrue(task5.isPalindromeDescendant(1221L));
    }

    @Test
    @DisplayName("Input with modifying test")
    public void testInputWithModifying() {
        Assertions.assertTrue(task5.isPalindromeDescendant(1L));
        Assertions.assertFalse(task5.isPalindromeDescendant(12L));
        Assertions.assertTrue(task5.isPalindromeDescendant(123L));
        Assertions.assertTrue(task5.isPalindromeDescendant(121));
        Assertions.assertTrue(task5.isPalindromeDescendant(31213));
        Assertions.assertTrue(task5.isPalindromeDescendant(4123214));

    }

}
