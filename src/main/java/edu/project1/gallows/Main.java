package edu.project1.gallows;

import edu.project1.gallows.application.GuessManager;
import edu.project1.gallows.application.RandomWordGenerator;
import edu.project1.gallows.utils.GraphicalProcessor;
import edu.project1.gallows.utils.UserInputReader;

@SuppressWarnings("RegexpSinglelineJava")
public final class Main {

    private static final int MAX_MISTAKE_NUMBERS = 5;

    private Main() {}

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.println("Welcome to the Gallows Game!");
        GuessManager guessManager = createGuessManager();
        int mistakes = 0;
        while (true) {
            displayGameState(guessManager, mistakes);
            Character letter = UserInputReader.receiveLetter();
            if (isNewLetter(guessManager, letter)) {
                if (guessLetter(guessManager, letter)) {
                    System.out.println("Correct guess!");
                } else {
                    System.out.println("Incorrect guess!");
                    mistakes++;
                    GraphicalProcessor.drawGallows(mistakes);
                    if (mistakes == MAX_MISTAKE_NUMBERS) {
                        endGame(guessManager);
                        break;
                    }
                }
            } else {
                System.out.println("You've already guessed that letter. Try another!");
            }
            if (hasUserWon(guessManager)) {
                celebrateWin();
                break;
            }
        }
    }

    private static GuessManager createGuessManager() {
        System.out.println("Game has been started! Type Ctrl+D (or Cmd+D for macOS) to exit.");
        String wordToGuess = RandomWordGenerator.getInstance().getRandomNoun();
        return new GuessManager(wordToGuess);
    }

    private static boolean isNewLetter(GuessManager guessManager, Character letter) {
        return guessManager.checkIsNewLetter(letter);
    }

    private static boolean guessLetter(GuessManager guessManager, Character letter) {
        return guessManager.guess(letter);
    }

    private static void displayGameState(GuessManager guessManager, int mistakes) {
        System.out.println("Guessed letters: " + guessManager.getNotepad().getCorrectLetters());
        System.out.println("Incorrect letters: " + guessManager.getNotepad().getIncorrectLetters());
        System.out.println(guessManager.getCurrentWord());
    }

    private static void endGame(GuessManager guessManager) {
        System.out.println("Game over! :(");
        System.out.println("The word was: " + guessManager.getWord());
        System.out.println("Would you like to play again?");
    }

    private static boolean hasUserWon(GuessManager guessManager) {
        return guessManager.checkIfUserWin();
    }

    private static void celebrateWin() {
        System.out.println("You won! Congratulations!");
    }

}
