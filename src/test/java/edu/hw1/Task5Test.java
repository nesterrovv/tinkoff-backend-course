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
        Assertions.assertFalse(task5.isPalindromeDescendant(1231L));
        Assertions.assertFalse(task5.isPalindromeDescendant(1223L));
        Assertions.assertTrue(task5.isPalindromeDescendant(11211230L));
        Assertions.assertTrue(task5.isPalindromeDescendant(13001120L));
        Assertions.assertTrue(task5.isPalindromeDescendant(23336014L));
        Assertions.assertTrue(task5.isPalindromeDescendant(123L));
        Assertions.assertFalse(task5.isPalindromeDescendant(234L));
        Assertions.assertFalse(task5.isPalindromeDescendant(32L));
        Assertions.assertTrue(task5.isPalindromeDescendant(0L));
    }

}
