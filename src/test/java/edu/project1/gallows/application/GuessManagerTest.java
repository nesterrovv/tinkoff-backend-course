package edu.project1.gallows.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GuessManagerTest {

    private GuessManager guessManager;

    @BeforeEach
    public void arrange() {
        guessManager = new GuessManager("example");
    }

    @Test
    public void shouldReturnTrueAndUpdateCurrentWordWhenGuessingCorrectLetter() {
        boolean result = guessManager.guess('e');
        assertThat(result).isTrue();
        assertThat(guessManager.getCurrentWord()).isEqualTo("e_____e");
    }

    @Test
    public void shouldReturnFalseWhenGuessingIncorrectLetter() {
        boolean result = guessManager.guess('q');
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnTrueForNewLetterAndFalseForAlreadyGuessedLetter() {
        guessManager.guess('a'); // Добавляем букву 'a' в notepad
        assertThat(guessManager.checkIsNewLetter('a')).isFalse(); // Буква уже угадана
        assertThat(guessManager.checkIsNewLetter('b')).isTrue(); // Новая буква
    }

    @Test
    public void shouldReturnTrueWhenUserWins() {
        guessManager.guess('e');
        guessManager.guess('x');
        guessManager.guess('a');
        guessManager.guess('m');
        guessManager.guess('p');
        guessManager.guess('l');
        assertThat(guessManager.checkIfUserWin()).isTrue();
    }

    @Test
    public void shouldReturnCorrectWord() {
        assertThat(guessManager.getWord()).isEqualTo("example");
    }

}
