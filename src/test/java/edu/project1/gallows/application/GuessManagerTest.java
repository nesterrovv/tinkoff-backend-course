package edu.project1.gallows.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GuessManagerTest {

    private GuessManager guessManager;

    @BeforeEach
    public void arrange() {
        // Arrange
        guessManager = new GuessManager("example");
    }

    @Test
    public void shouldReturnTrueAndUpdateCurrentWordWhenGuessingCorrectLetter() {
        // Arrange
        char letterToGuess = 'e';
        // Act
        boolean result = guessManager.guess(letterToGuess);
        // Assert
        assertThat(result).isTrue();
        assertThat(guessManager.getCurrentWord()).isEqualTo("e_____e");
    }

    @Test
    public void shouldReturnFalseWhenGuessingIncorrectLetter() {
        // Arrange
        char letterToGuess = 'q';
        // Act
        boolean result = guessManager.guess(letterToGuess);
        // Assert
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnTrueForNewLetterAndFalseForAlreadyGuessedLetter() {
        // Arrange
        char letterA = 'a';
        char letterB = 'b';
        // Act
        guessManager.guess(letterA);
        // Assert
        assertThat(guessManager.checkIsNewLetter(letterA)).isFalse();
        assertThat(guessManager.checkIsNewLetter(letterB)).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenUserWins() {
        // Arrange
        char[] lettersToGuess = {'e', 'x', 'a', 'm', 'p', 'l'};
        // Act
        for (char letter : lettersToGuess) {
            guessManager.guess(letter);
        }
        // Assert
        assertThat(guessManager.checkIfUserWin()).isTrue();
    }

    @Test
    public void shouldReturnCorrectWord() {
        // Act
        String word = guessManager.getWord();
        // Assert
        assertThat(word).isEqualTo("example");
    }

}
