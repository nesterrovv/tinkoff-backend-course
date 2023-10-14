package edu.project1.gallows;

import edu.project1.gallows.application.GuessManager;
import edu.project1.gallows.application.RandomWordGenerator;
import edu.project1.gallows.utils.GraphicalProcessor;
import edu.project1.gallows.utils.UserInputReader;

public final class Main {

    private static final int MAX_MISTAKE_NUMBERS = 5;

    private Main() {}

    public static void main(String[] args) {
        play();
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void play() {
        System.out.println("Game has been started! Type ctrl + D (or cmd + D for macOS) for exit.");
        GuessManager guessManager = new GuessManager(RandomWordGenerator.getInstance().getRandomNoun());
        int mistakes = 0;
        while (true) {
            System.out.println("Guessed letters: " + guessManager.getNotepad().getCorrectLetters());
            System.out.println("Incorrect letters: " + guessManager.getNotepad().getIncorrectLetters());
            System.out.println(guessManager.getCurrentWord());
            Character letter = UserInputReader.receiveLetter();
            if (guessManager.checkIsNewLetter(letter)) {
                if (guessManager.guess(letter)) {
                    System.out.println("This is correct letter!");
                } else {
                    System.out.println("This is incorrect letter!");
                    mistakes++;
                    GraphicalProcessor.drawGallows(mistakes);
                    if (mistakes == MAX_MISTAKE_NUMBERS) {
                        System.out.println("Game over! :(");
                        System.out.println("The word was: " + guessManager.getWord());
                        System.out.println("Let's play again?");
                        break;
                    }
                }
            } else {
                System.out.println("This letter has been already entered. Try another!");
            }
            if (guessManager.checkIfUserWin()) {
                System.out.println("You won! Congratulations!");
                break;
            }
        }
    }
}
