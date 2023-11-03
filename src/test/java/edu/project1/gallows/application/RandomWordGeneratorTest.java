package edu.project1.gallows.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RandomWordGeneratorTest {

    private RandomWordGenerator wordGenerator;

    @BeforeEach
    public void arrange() {
        // Arrange
        wordGenerator = RandomWordGenerator.getInstance();
    }

    @Test
    public void shouldContainsNounsFromResource() {
        // Act
        boolean nounsNotEmpty = !wordGenerator.getNouns().isEmpty();
        // Assert
        assertThat(nounsNotEmpty).isTrue();
    }

    @Test
    public void shouldReturnRandomNoun() {
        // Act
        String randomNoun = wordGenerator.getRandomNoun();
        // Assert
        assertThat(randomNoun).isNotNull();
        assertThat(wordGenerator.getNouns()).contains(randomNoun);
    }

    @Test
    public void shouldReturnSameInstance() {
        // Act
        RandomWordGenerator instance1 = RandomWordGenerator.getInstance();
        RandomWordGenerator instance2 = RandomWordGenerator.getInstance();
        // Assert
        assertThat(instance1).isSameAs(instance2);
    }

}
