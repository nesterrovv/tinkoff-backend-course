package edu.hw1;

import edu.exceptions.IncorrectArgumentException;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

public class Task6 {

    private static final Logger LOGGER = Logger.getLogger("LOGGER");
    private static final int KAPREKARS_CONSTANT = 6174;
    private static final int BASE = 10;
    private static final int MINIMAL_FOUR_DIGIT_NUMBER = 1000;
    private static final int MAXIMAL_FOUR_DIGIT_NUMBER = 9999;

    public int countK(int n) {
        try {
            if (n < MINIMAL_FOUR_DIGIT_NUMBER || n > MAXIMAL_FOUR_DIGIT_NUMBER) {
                throw new IncorrectArgumentException();
            }
            int number = n;
            int counter = 0;
            while (number != KAPREKARS_CONSTANT) {
                number = modify(number);
                counter++;
            }
            return counter;
        } catch (IncorrectArgumentException incorrectArgumentException) {
            LOGGER.severe(incorrectArgumentException.getMessage());
            return -1;
        }
    }

    private int modify(int n) {
        int argument = n;
        while (!(argument >= MINIMAL_FOUR_DIGIT_NUMBER && argument <= MAXIMAL_FOUR_DIGIT_NUMBER)) {
            argument *= BASE;
        }
        String numberStr = Long.toString(argument);
        char[] firstNumberDigits = numberStr.toCharArray();
        Arrays.sort(firstNumberDigits);
        String sortedNumberStr = new String(firstNumberDigits);
        int first = Integer.parseInt(sortedNumberStr);
        Character[] secondNumberDigits = new Character[numberStr.length()];
        for (int i = 0; i < numberStr.length(); i++) {
            secondNumberDigits[i] = numberStr.charAt(i);
        }
        Arrays.sort(secondNumberDigits, Collections.reverseOrder());
        StringBuilder sortedNumberStr2 = new StringBuilder();
        for (char digit : secondNumberDigits) {
            sortedNumberStr2.append(digit);
        }
        int second = Integer.parseInt(sortedNumberStr2.toString());
        return second - first;
    }

}
