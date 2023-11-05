package edu.project1.gallows;

import edu.project1.gallows.application.AccountManager;
import edu.project1.gallows.application.GuessManager;
import edu.project1.gallows.application.RandomWordGenerator;
import edu.project1.gallows.model.User;
import edu.project1.gallows.security.Cryptographer;
import edu.project1.gallows.util.SerializerToCSV;
import edu.project1.gallows.utils.GraphicalProcessor;
import edu.project1.gallows.utils.UserInputReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Main {

    private static final int MAX_MISTAKE_NUMBERS = 5;

    private Main() {}

    public static void main(String[] args) {
        if (args.length < 2) {
            log.warn("You need enter your login and password as command line arguments for starting the game.");
        } else {
            String login = args[0];
            String password = args[1];
            startGame(login, password);
        }
        SerializerToCSV.serializeUsersToCSV(AccountManager.getUsers());
    }

    public static void startGame(String login, String password) {
        authorize(login, password);
        sayHello();
        GuessManager guessManager = createGuessManager();
        int mistakes = 0;
        while (true) {
            displayGameState(guessManager);
            Character letter = UserInputReader.receiveLetter();
            if (isNewLetter(guessManager, letter)) {
                if (guessLetter(guessManager, letter)) {
                    log.info("Correct guess!");
                } else {
                    log.info("Incorrect guess!");
                    mistakes++;
                    GraphicalProcessor.drawGallows(mistakes);
                    if (mistakes == MAX_MISTAKE_NUMBERS) {
                        endGame(guessManager);
                        break;
                    }
                }
            } else {
                log.warn("You've already guessed that letter. Try another!");
            }
            if (hasUserWon(guessManager)) {
                celebrateWin();
                break;
            }
        }
    }

    private static GuessManager createGuessManager() {
        log.info("Game has been started! Type Ctrl+D (or Cmd+D for macOS) to exit.");
        String wordToGuess = RandomWordGenerator.getInstance().getRandomNoun();
        return new GuessManager(wordToGuess);
    }

    private static boolean isNewLetter(GuessManager guessManager, Character letter) {
        return guessManager.checkIsNewLetter(letter);
    }

    private static boolean guessLetter(GuessManager guessManager, Character letter) {
        return guessManager.guess(letter);
    }

    private static void displayGameState(GuessManager guessManager) {
        log.info("Guessed letters: " + guessManager.getNotepad().getCorrectLetters());
        log.info("Incorrect letters: " + guessManager.getNotepad().getIncorrectLetters());
        log.info(guessManager.getCurrentWord());
    }

    private static void endGame(GuessManager guessManager) {
        log.info("Game over! :(");
        log.info("The word was: " + guessManager.getWord());
        log.info("Would you like to play again?");
        AccountManager.getCurrentUser().increaseLoses();
    }

    private static boolean hasUserWon(GuessManager guessManager) {
        return guessManager.checkIfUserWin();
    }

    private static void celebrateWin() {
        log.info("You won! Congratulations!");
        AccountManager.getCurrentUser().increaseWins();
    }

    private static void authorize(String login, String password) {
        User user = new User(login, Cryptographer.encrypt(password));
        if (AccountManager.checkIfUserExists(user)) {
            int wins = user.getWins();
            int loses = user.getLoses();
            AccountManager.login(user);
        } else {
            AccountManager.register(user);
            AccountManager.login(user);
        }
        log.info("Welcome to the Gallows Game!");
        log.info("Your statistics:");
        log.info("Name: " + AccountManager.getCurrentUser().getLogin());
        log.info("Wins: " + AccountManager.getCurrentUser().getWins());
        log.info("Loses: " + AccountManager.getCurrentUser().getLoses());
    }

    private static void sayHello() {
        log.info("Welcome to the Gallows Game!");
        log.info("Your statistics:");
        log.info("Name: " + AccountManager.getCurrentUser().getLogin());
        log.info("Wins: " + AccountManager.getCurrentUser().getWins());
        log.info("Loses: " + AccountManager.getCurrentUser().getLoses());
    }

}
