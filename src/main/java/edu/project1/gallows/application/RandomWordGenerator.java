package edu.project1.gallows.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class RandomWordGenerator {

    private static final String PATH_TO_WORDS = "/project1/words.csv";
    private static RandomWordGenerator instance;
    private final Set<String> nouns = new HashSet<>();

    private RandomWordGenerator() {
        loadNounsFromResource();
    }

    public static RandomWordGenerator getInstance() {
        if (instance == null) {
            instance = new RandomWordGenerator();
        }
        return instance;
    }

    public String getRandomNoun() {
        Random random = new Random();
        int index = random.nextInt(nouns.size());
        int i = 0;
        for (String noun : nouns) {
            if (i == index) {
                return noun;
            }
            i++;
        }
        return null;
    }

    private void loadNounsFromResource() {
        try (InputStream inputStream = getClass().getResourceAsStream(PATH_TO_WORDS)) {
            assert inputStream != null;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    nouns.add(line.trim());
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public Set<String> getNouns() {
        return nouns;
    }

}
