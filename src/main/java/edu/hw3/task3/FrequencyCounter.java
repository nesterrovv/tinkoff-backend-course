package edu.hw3.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FrequencyCounter {

    private FrequencyCounter() {}

    public static <T> Map<T, Integer> countFrequency(List<T> list) {
        Map<T, Integer> frequencyCounter = new HashMap<>();
        for (T element : list) {
            frequencyCounter.put(element, frequencyCounter.getOrDefault(element, 0) + 1);
        }
        return frequencyCounter;
    }

}
