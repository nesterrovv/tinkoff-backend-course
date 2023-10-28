package edu.hw3.task2;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class BracketClustererTest {

    @Test
    public void testClusterizeWithValidInput() {
        // Arrange
        String input = "((()))(())()()(()())";
        // Act
        List<String> clusters = BracketClusterer.clusterize(input);
        // Assert
        assertThat(clusters).hasSize(5).containsExactly("((()))", "(())", "()", "()", "(()())");
    }

    @Test
    public void testClusterizeWithInvalidInput() {
        // Arrange
        String input = "(()";
        // Act
        List<String> clusters = BracketClusterer.clusterize(input);
        // Assert
        assertThat(clusters).isEmpty();
    }

    @Test
    public void testClusterizeWithNullInput() {
        // Act
        List<String> clusters = BracketClusterer.clusterize(null);
        // Assert
        assertThat(clusters).isEmpty();
    }

}
