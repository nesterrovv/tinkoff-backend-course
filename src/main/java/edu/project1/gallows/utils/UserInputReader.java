package edu.project1.gallows.utils;

import lombok.extern.slf4j.Slf4j;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Slf4j
public final class UserInputReader {

    private static final Scanner SCANNER;

    static {
        SCANNER = new Scanner(System.in);
    }

    private UserInputReader() {}

    public static Character receiveLetter() {
        while (true) {
            try {
                log.info("Input letter:");
                String input = SCANNER.nextLine().toLowerCase();
                if (input.length() == 1) {
                    char letter = input.charAt(0);
                    if (Character.isLetter(letter)) {
                        return letter;
                    } else {
                        log.info("That's not letter. Try again.");
                    }
                } else {
                    log.info("Input should be one letter. Try again.");
                }
            } catch (NoSuchElementException exception) {
                // info level because it's the correct way of program finishing
                log.info("Program will be finished now!");
                System.exit(0);
            }
        }
    }

}
