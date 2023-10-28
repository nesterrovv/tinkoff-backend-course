package edu.hw3.task7;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NullComparatorTest {

    @Test
    public void testNullComparing() {
        // Arrange
        TreeMap<Integer, Integer> tree = new TreeMap<>(new NullComparator<>());
        // Act
        tree.put(null, 42);
        // Assert
        assertThat(tree.containsKey(null)).isTrue();
    }

}
