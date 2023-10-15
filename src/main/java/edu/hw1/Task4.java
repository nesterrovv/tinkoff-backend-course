package edu.hw1;

public class Task4 {

    public String fixString(String initial) {
        if (initial == null || initial.isEmpty()) {
            return "";
        }
        StringBuilder fixedString = new StringBuilder();
        int length = initial.length();
        int endIndex = (length % 2 == 0) ? length : length - 1;
        for (int i = 1; i < endIndex; i += 2) {
            fixedString.append(initial.charAt(i)).append(initial.charAt(i - 1));
        }
        if (endIndex < length) {
            fixedString.append(initial.charAt(length - 1));
        }
        return fixedString.toString();
    }

}
