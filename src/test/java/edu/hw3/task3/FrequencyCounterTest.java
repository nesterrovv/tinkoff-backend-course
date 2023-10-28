package edu.hw3.task3;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static edu.hw3.task3.FrequencyCounter.countFrequency;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class FrequencyCounterTest {

    @Test
    void testNumbersCountry() {
        // Arrange
        List<Integer> numbers = List.of(1, 2, 3, 1);
        // Act
        Map<Integer, Integer> numberFreq = countFrequency(numbers);
        // Assert
        assertThat(numberFreq).hasSize(3).containsOnly(entry(1, 2), entry(2, 1), entry(3, 1));
    }

    @Test
    void testWordsDictionary() {
        // Arrange
        List<String> words = List.of("abc", "def", "abc", "def");
        // Act
        Map<String, Integer> wordFreq = countFrequency(words);
        // Assert
        assertThat(wordFreq).hasSize(2).containsOnly(entry("abc", 2), entry("def", 2));
    }

}
