package edu.hw3.task1;

public final class AtbashCipher {

    private static final int MAX_ALPHABET_SHIFT = 25;
    private static final int MIRROR_SHIFT = 2;

    private AtbashCipher() {}

    public static String encrypt(String stringForEncrypt) {
        if (stringForEncrypt == null) {
            return null;
        } else {
            StringBuilder encryptedString = new StringBuilder();
            for (int i = 0; i < stringForEncrypt.length(); i++) {
                char currentSymbol = stringForEncrypt.charAt(i);
                if (Character.isLetter(currentSymbol)) {
                    encryptedString.append(encryptLetter(currentSymbol));
                } else {
                    encryptedString.append(currentSymbol);
                }
            }
            return encryptedString.toString();
        }
    }

    private static char encryptLetter(char letter) {
        int baseCodePointStart = Character.isUpperCase(letter) ? 'A' : 'a';
        int baseCodePointEnd = Character.isUpperCase(letter) ? 'Z' : 'z';
        if (isFirstHalfOfAlphabet(letter)) {
            int shiftFromStartOfAlphabet = letter - baseCodePointStart;
            return (char) (letter + (MAX_ALPHABET_SHIFT  - MIRROR_SHIFT * shiftFromStartOfAlphabet));
        } else {
            int shiftFromEndOfAlphabet = baseCodePointEnd - letter;
            return (char) (letter - (MAX_ALPHABET_SHIFT  - MIRROR_SHIFT * shiftFromEndOfAlphabet));
        }
    }

    private static boolean isFirstHalfOfAlphabet(char letter) {
        return letter >= 'A' && letter <= 'M' || letter >= 'a' && letter <= 'm';
    }

}
