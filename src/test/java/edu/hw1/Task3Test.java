package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    private final Task3 task3 = new Task3();

    @Test
    @DisplayName("Base inputs test")
    public void testBaseInput() {
        // Arrange
        int[] arrayA = new int[] {1, 2, 3, 4};
        int[] arrayB = new int[] {0, 6};
        int[] arrayC = new int[] {3, 1};
        int[] arrayD = new int[] {4, 0};
        int[] arrayE = new int[] {9, 9, 8};
        int[] arrayF = new int[] {8, 9};
        int[] arrayG = new int[] {1, 2, 3, 4};
        int[] arrayH = new int[] {2, 3};
        // Act
        boolean result1 = task3.isNestable(arrayA, arrayB);
        boolean result2 = task3.isNestable(arrayC, arrayD);
        boolean result3 = task3.isNestable(arrayE, arrayF);
        boolean result4 = task3.isNestable(arrayG, arrayH);
        // Assert
        assertThat(result1).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
    }

    @Test
    @DisplayName("Equal arrays input test")
    public void testMonotonicEqualsInput() {
        // Arrange
        int[] arrayA = new int[] {1, 10};
        int[] arrayB = new int[] {1, 20};
        int[] arrayC = new int[] {1, 10};
        int[] arrayD = new int[] {2, 10};
        int[] arrayE = new int[] {1, 2};
        int[] arrayF = new int[] {1, 2};
        // Act
        boolean result1 = task3.isNestable(arrayA, arrayB);
        boolean result2 = task3.isNestable(arrayC, arrayD);
        boolean result3 = task3.isNestable(arrayE, arrayF);
        // Assert
        assertThat(result1).isFalse();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
    }

    @Test
    @DisplayName("Empty input test")
    public void testEmptyInput() {
        // Arrange
        int[] arrayA = new int[] {1, 2, 3, 4};
        int[] arrayB = new int[0];
        int[] arrayC = new int[0];
        int[] arrayD = new int[] {4, 0};
        int[] arrayE = new int[0];
        int[] arrayF = new int[0];
        // Act
        boolean result1 = task3.isNestable(arrayA, arrayB);
        boolean result2 = task3.isNestable(arrayC, arrayD);
        boolean result3 = task3.isNestable(arrayE, arrayF);
        // Assert
        assertThat(result1).isFalse();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
    }

    @Test
    @DisplayName("Null input test")
    public void testNullInput() {
        // Arrange
        int[] arrayA = null;
        int[] arrayB = new int[] {1, 2};
        int[] arrayC = new int[] {1, 2};
        int[] arrayD = null;
        int[] arrayE = null;
        int[] arrayF = null;
        // Act
        boolean result1 = task3.isNestable(arrayA, arrayB);
        boolean result2 = task3.isNestable(arrayC, arrayD);
        boolean result3 = task3.isNestable(arrayE, arrayF);
        // Assert
        assertThat(result1).isFalse();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
    }

}
