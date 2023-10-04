package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {

    private final Task3 task3 = new Task3();

    @Test
    @DisplayName("Base inputs test")
    public void testBaseInput() {
        Assertions.assertTrue(task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6}));
        Assertions.assertTrue(task3.isNestable(new int[] {3, 1}, new int[] {4, 0}));
        Assertions.assertFalse(task3.isNestable(new int[] {9, 9, 8}, new int[] {8, 9}));
        Assertions.assertFalse(task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3}));
    }

    @Test
    @DisplayName("Equal arrays input test")
    public void testMonotonicEqualsInput() {
        Assertions.assertFalse(task3.isNestable(new int[] {1, 10}, new int[] {1, 20}));
        Assertions.assertFalse(task3.isNestable(new int[] {1, 10}, new int[] {2, 10}));
        Assertions.assertFalse(task3.isNestable(new int[] {1, 2}, new int[] {1, 2}));
    }

    @Test
    @DisplayName("Empty input test")
    public void testEmptyInput() {
        Assertions.assertFalse(task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {}));
        Assertions.assertFalse(task3.isNestable(new int[] {}, new int[] {4, 0}));
        Assertions.assertFalse(task3.isNestable(new int[] {}, new int[] {}));
    }

    @Test
    @DisplayName("Null input test")
    public void testNullInput() {
        Assertions.assertFalse(task3.isNestable(null, new int[] {1, 2}));
        Assertions.assertFalse(task3.isNestable(new int[] {1, 2}, null));
        Assertions.assertFalse(task3.isNestable(null, null));
    }
}
