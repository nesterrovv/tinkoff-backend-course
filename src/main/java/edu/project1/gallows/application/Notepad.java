package edu.project1.gallows.application;

import java.util.LinkedHashSet;
import java.util.Set;

public class Notepad {

    private final Set<Character> incorrectLetters;
    private final Set<Character> correctLetters;

    public Notepad() {
        this.incorrectLetters = new LinkedHashSet<>();
        this.correctLetters = new LinkedHashSet<>();
    }

    public void addIncorrectLetter(Character character) {
        this.incorrectLetters.add(character);
    }

    public void addCorrectLetter(Character character) {
        this.correctLetters.add(character);
    }

    public Set<Character> getCorrectLetters() {
        return correctLetters;
    }

    public Set<Character> getIncorrectLetters() {
        return incorrectLetters;
    }

}
