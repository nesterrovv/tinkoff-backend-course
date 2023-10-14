package edu.project1.gallows.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NotepadTest {

    private Notepad notepad;

    @BeforeEach
    public void arrange() {
        notepad = new Notepad();
    }

    @Test
    public void shouldAddIncorrectLetter() {
        notepad.addIncorrectLetter('a');
        Set<Character> incorrectLetters = notepad.getIncorrectLetters();
        Assertions.assertThat(incorrectLetters).contains('a');
    }

    @Test
    public void shouldAddCorrectLetter() {
        notepad.addCorrectLetter('b');
        Set<Character> correctLetters = notepad.getCorrectLetters();
        Assertions.assertThat(correctLetters).contains('b');
    }

    @Test
    public void shouldReturnCorrectLetters() {
        notepad.addCorrectLetter('c');
        notepad.addCorrectLetter('d');
        Set<Character> correctLetters = notepad.getCorrectLetters();
        Assertions.assertThat(correctLetters).containsExactly('c', 'd');
    }

    @Test
    public void shouldReturnIncorrectLetters() {
        notepad.addIncorrectLetter('x');
        notepad.addIncorrectLetter('y');
        Set<Character> incorrectLetters = notepad.getIncorrectLetters();
        Assertions.assertThat(incorrectLetters).containsExactly('x', 'y');
    }

}
