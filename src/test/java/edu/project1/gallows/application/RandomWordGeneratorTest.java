package edu.project1.gallows.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomWordGeneratorTest {

    private RandomWordGenerator wordGenerator;

    @BeforeEach
    public void arrange() {
        wordGenerator = RandomWordGenerator.getInstance();
    }

    @Test
    public void shouldContainsNounsFromResource() {
        assertThat(wordGenerator.getNouns()).isNotEmpty();
    }

    @Test
    public void shouldReturnRandomNoun() {
        String randomNoun = wordGenerator.getRandomNoun();
        assertThat(randomNoun).isNotNull();
        assertThat(wordGenerator.getNouns()).contains(randomNoun);
    }

    @Test
    public void shouldReturnSameInstance() {
        RandomWordGenerator instance1 = RandomWordGenerator.getInstance();
        RandomWordGenerator instance2 = RandomWordGenerator.getInstance();
        assertThat(instance1).isSameAs(instance2);
    }

}
