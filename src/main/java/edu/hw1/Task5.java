package edu.hw1;

public final class Task5 {

    private static final long MINIMAL_DOUBLE_DIGIT_PALINDROME = 11L;
    private static final long MAXIMAL_DOUBLE_DIGIT_PALINDROME = 99L;
    private static boolean isInitialNumber = true;

    public boolean isPalindromeDescendant(long initial) {
        isInitialNumber = true;
        return checkIsPalindromeDescendant(initial);
    }

    private boolean checkIsPalindromeDescendant(long initial) {
        if (isPalindrome(initial)) {
            return true;
        }
        long current = initial;
        String strCurrent = Long.toString(current);
        if (strCurrent.length() == 1 && isInitialNumber) {
            isInitialNumber = false;
            return true;
        } else if (strCurrent.length() == 2) {
            long modified = modifyNumber(current);
            return isPalindrome(current) || (isPalindrome(modified) && modified >= MINIMAL_DOUBLE_DIGIT_PALINDROME
                && modified <= MAXIMAL_DOUBLE_DIGIT_PALINDROME);
        } else {
            current = modifyNumber(current);
            return checkIsPalindromeDescendant(current);
        }
    }


    private boolean isPalindrome(long number) {
        String stringNumber = Long.toString(number);
        for (int i = 0; i < stringNumber.length() / 2; i++) {
            if (stringNumber.charAt(i) != stringNumber.charAt(stringNumber.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private long modifyNumber(long initial) {
        String stringNumber = Long.toString(initial);
        if (stringNumber.length() == 1) {
            return initial;
        }
        int endIndex = (stringNumber.length() % 2 == 0) ? stringNumber.length() : stringNumber.length() - 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < endIndex; i += 2) {
            Long first = Long.parseLong(String.valueOf(stringNumber.charAt(i)));
            Long second = Long.parseLong(String.valueOf(stringNumber.charAt(i - 1)));
            result.append(first + second);

        }
        if (endIndex < stringNumber.length()) {
            result.append(stringNumber.charAt(stringNumber.length() - 1));
        }
        return Long.parseLong(result.toString());
    }

}
