package edu.project1.gallows.application;

import java.util.HashSet;
import java.util.Set;

public class GuessManager {

    private final String word;
    private final Set<Character> letters;
    private final StringBuilder currentWord;
    private int lettersOpened;
    private final Notepad notepad;


    public GuessManager(String word) {
        this.word = word;
        this.letters = getLettersSet(word);
        this.currentWord = getInitialWordCondition(word);
        this.lettersOpened = 0;
        this.notepad = new Notepad();
    }

    public boolean guess(Character guessingCharacter) {
        if (this.letters.contains(guessingCharacter)) {
            this.notepad.addCorrectLetter(guessingCharacter);
            openLetter(guessingCharacter);
            return true;
        } else {
            notepad.addIncorrectLetter(guessingCharacter);
            return false;
        }
    }

    public boolean checkIsNewLetter(Character letter) {
        return !this.notepad.getCorrectLetters().contains(letter)
            && !this.notepad.getIncorrectLetters().contains(letter);
    }

    public String getCurrentWord() {
        return this.currentWord.toString();
    }

    private Set<Character> getLettersSet(String word) {
        Set<Character> set = new HashSet<>();
        for (Character character : word.toCharArray()) {
            set.add(character);
        }
        return set;
    }

    public boolean checkIfUserWin() {
        return this.lettersOpened == this.word.length();
    }

    public Notepad getNotepad() {
        return this.notepad;
    }

    public String getWord() {
        return word;
    }

    private StringBuilder getInitialWordCondition(String word) {
        return new StringBuilder("_".repeat(word.length()));
    }

    private void openLetter(char letter) {
        for (int i = 0; i < this.word.length(); i++) {
            char currentLetter = this.word.charAt(i);
            if (currentLetter == letter) {
                this.currentWord.setCharAt(i, letter);
                lettersOpened++;
            }
        }
    }
}
