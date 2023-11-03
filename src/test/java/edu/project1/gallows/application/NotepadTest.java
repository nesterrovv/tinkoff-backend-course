package edu.project1.gallows.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class NotepadTest {

    private Notepad notepad;

    @BeforeEach
    public void arrange() {
        // Arrange
        notepad = new Notepad();
    }

    @Test
    public void shouldAddIncorrectLetter() {
        // Arrange
        char letter = 'a';
        // Act
        notepad.addIncorrectLetter(letter);
        // Assert
        Set<Character> incorrectLetters = notepad.getIncorrectLetters();
        Assertions.assertThat(incorrectLetters).contains(letter);
    }

    @Test
    public void shouldAddCorrectLetter() {
        // Arrange
        char letter = 'b';
        // Act
        notepad.addCorrectLetter(letter);
        // Assert
        Set<Character> correctLetters = notepad.getCorrectLetters();
        Assertions.assertThat(correctLetters).contains(letter);
    }

    @Test
    public void shouldReturnCorrectLetters() {
        // Arrange
        char letter1 = 'c';
        char letter2 = 'd';
        // Act
        notepad.addCorrectLetter(letter1);
        notepad.addCorrectLetter(letter2);
        // Assert
        Set<Character> correctLetters = notepad.getCorrectLetters();
        Assertions.assertThat(correctLetters).containsExactly(letter1, letter2);
    }

    @Test
    public void shouldReturnIncorrectLetters() {
        // Arrange
        char letter1 = 'x';
        char letter2 = 'y';
        // Act
        notepad.addIncorrectLetter(letter1);
        notepad.addIncorrectLetter(letter2);
        // Assert
        Set<Character> incorrectLetters = notepad.getIncorrectLetters();
        Assertions.assertThat(incorrectLetters).containsExactly(letter1, letter2);
    }

}
