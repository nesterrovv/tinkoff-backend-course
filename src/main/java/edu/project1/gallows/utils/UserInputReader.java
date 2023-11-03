package edu.project1.gallows.utils;

import java.util.NoSuchElementException;
import java.util.Scanner;

public final class UserInputReader {

    private static final Scanner SCANNER;

    static {
        SCANNER = new Scanner(System.in);
    }

    private UserInputReader() {}

    @SuppressWarnings("RegexpSinglelineJava")
    public static Character receiveLetter() {
        while (true) {
            try {
                System.out.println("Input letter:");
                String input = SCANNER.nextLine().toLowerCase();
                if (input.length() == 1) {
                    char letter = input.charAt(0);
                    if (Character.isLetter(letter)) {
                        return letter;
                    } else {
                        System.out.println("That's not letter. Try again.");
                    }
                } else {
                    System.out.println("Input should be one letter. Try again.");
                }
            } catch (NoSuchElementException exception) {
                System.out.println("Program will be finished now!");
                System.exit(0);
            }
        }
    }

}
