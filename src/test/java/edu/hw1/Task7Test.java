package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task7Test {

    private final Task7 task7 = new Task7();

    @Test
    @DisplayName("Rotate left for base input test")
    public void testRotateLeftInputWithoutModifying() {
        Assertions.assertEquals(1, task7.rotateLeft(16, 1));
        Assertions.assertEquals(6, task7.rotateLeft(9, 2));
        Assertions.assertEquals(6, task7.rotateLeft(17, 2));
        Assertions.assertEquals(7, task7.rotateLeft(7, 4));
    }

    @Test
    @DisplayName("Rotate left for numbers equals of (2^n - 1) test")
    public void testRotateLeftInputWithOnlyOnes() {
        Assertions.assertEquals(1023, task7.rotateLeft(1023, 10));
        Assertions.assertEquals(65535, task7.rotateLeft(65535, 100));
        Assertions.assertEquals(2047, task7.rotateLeft(2047, 1000));
        Assertions.assertEquals(3, task7.rotateLeft(3, 5));
    }

    @Test
    @DisplayName("Rotate left for zero input test")
    public void testRotateLeftInputZero() {
        Assertions.assertEquals(0, task7.rotateLeft(0, 10));
        Assertions.assertEquals(0, task7.rotateLeft(0, 100));
    }

    @Test
    @DisplayName("Rotate left for incorrect input test")
    public void testRotateLeftIncorrectInput() {
        Assertions.assertEquals(-1, task7.rotateLeft(-10, 10));
        Assertions.assertEquals(-1, task7.rotateLeft(10, -10));
        Assertions.assertEquals(-1, task7.rotateLeft(-10, -10));
    }

    @Test
    @DisplayName("Rotate right for base input test")
    public void testRotateRightInputWithoutModifying() {
        Assertions.assertEquals(4, task7.rotateRight(16, 2));
        Assertions.assertEquals(8, task7.rotateRight(16, 1));
        Assertions.assertEquals(12, task7.rotateRight(17, 2));
        Assertions.assertEquals(7, task7.rotateRight(7, 4));
        Assertions.assertEquals(1023, task7.rotateRight(1023, 1000));
    }

    @Test
    @DisplayName("Rotate right for numbers equals of (2^n - 1) test")
    public void testRotateRightInputWithOnlyOnes() {
        Assertions.assertEquals(1023, task7.rotateRight(1023, 10));
        Assertions.assertEquals(65535, task7.rotateRight(65535, 100));
        Assertions.assertEquals(2047, task7.rotateRight(2047, 1000));
        Assertions.assertEquals(3, task7.rotateRight(3, 5));
    }

    @Test
    @DisplayName("Rotate right for zero input test")
    public void testRotateRightInputZero() {
        Assertions.assertEquals(0, task7.rotateRight(0, 10));
        Assertions.assertEquals(0, task7.rotateRight(0, 100));
    }

    @Test
    @DisplayName("Rotate right for incorrect input test")
    public void testRotateRightIncorrectInput() {
        Assertions.assertEquals(-1, task7.rotateRight(-10, 10));
        Assertions.assertEquals(-1, task7.rotateRight(10, -10));
        Assertions.assertEquals(-1, task7.rotateRight(-10, -10));
    }

}
