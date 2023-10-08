package edu.hw1;

import edu.exceptions.IncorrectArgumentException;
import java.util.logging.Logger;

public class Task7 {

    private final static Logger LOGGER = Logger.getLogger("LOGGER");

    public int rotateLeft(int n, int shift) {
        try {
            if (n < 0 || shift < 0) {
                throw new IncorrectArgumentException();
            }
            if (n == 0) {
                return 0;
            }
            String binaryNumber = toBinaryNumberSystem(n);
            int shiftCounter = 0;
            while (shiftCounter < shift) {
                binaryNumber = leftShift(binaryNumber);
                shiftCounter++;
            }
            return toDecimalNumberSystem(binaryNumber);
        } catch (IncorrectArgumentException incorrectArgumentException) {
            LOGGER.warning(incorrectArgumentException.getMessage());
            return -1;
        }
    }

    public int rotateRight(int n, int shift) {
        try {
            if (n < 0 || shift < 0) {
                throw new IncorrectArgumentException();
            }
            if (n == 0) {
                return 0;
            }
            String binaryNumber = toBinaryNumberSystem(n);
            int shiftCounter = 0;
            while (shiftCounter < shift) {
                binaryNumber = rightShift(binaryNumber);
                shiftCounter++;
            }
            return toDecimalNumberSystem(binaryNumber);
        } catch (IncorrectArgumentException incorrectArgumentException) {
            LOGGER.warning(incorrectArgumentException.getMessage());
            return -1;
        }
    }

    private String toBinaryNumberSystem(int decimal) {
        StringBuilder result = new StringBuilder();
        int number = decimal;
        while (number != 1) {
            result.append(number % 2);
            number /= 2;
        }
        result.append(1);
        result.reverse();
        return result.toString();
    }

    private int toDecimalNumberSystem(String binary) {
        StringBuilder binaryNumber = new StringBuilder(binary);
        binaryNumber.reverse();
        int result = 0;
        int currentPowOfTwo = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            result += Integer.parseInt(String.valueOf(binaryNumber.charAt(i))) * Math.pow(2, currentPowOfTwo);
            currentPowOfTwo += 1;
        }
        return result;
    }

    private String leftShift(String binaryNumber) {
        StringBuilder number = new StringBuilder(binaryNumber);
        char tmp = number.charAt(0);
        for (int i = 1; i < number.length(); i++) {
            number.setCharAt(i - 1, number.charAt(i));
        }
        number.setCharAt(number.length() - 1, tmp);
        return number.toString();
    }

    private String rightShift(String binaryNumber) {
        StringBuilder number = new StringBuilder(binaryNumber);
        char tmp = number.charAt(number.length() - 1);
        for (int i = number.length() - 2; i >= 0; i--) {
            number.setCharAt(i + 1, number.charAt(i));
        }
        number.setCharAt(0, tmp);
        return number.toString();
    }

}
