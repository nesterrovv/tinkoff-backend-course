package edu.hw3.task4;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("MagicNumber")
public final class IntegerToRomanUtil {

    public static final int ROMAN_MAX_VALUE = 3999;
    public static final String ROMAN_ZERO = "N";
    public static final Map<String, Integer> ROMAN_NUMERALS_MAP = new LinkedHashMap<>() {{
        put("M",  1000);
        put("CM", 900);
        put("D",  500);
        put("CD", 400);
        put("C",  100);
        put("XC", 90);
        put("L",  50);
        put("XL", 40);
        put("X",  10);
        put("IX", 9);
        put("V",  5);
        put("IV", 4);
        put("I",  1);
    }};

    private IntegerToRomanUtil() {}

    public static String convertToRomanNumber(int number) {
        if (number < 0) {
            return "Roman numbers cannot be negative.";
        }
        if (number == 0) {
            return ROMAN_ZERO;
        }
        if (number > ROMAN_MAX_VALUE) {
            return "Max allowed value is " + ROMAN_MAX_VALUE;
        }
        return convert(number);
    }

    private static String convert(int arabicNumber) {
        int value = arabicNumber;
        StringBuilder romanNumber = new StringBuilder();
        for (var entry : ROMAN_NUMERALS_MAP.entrySet()) {
            while (value >= entry.getValue()) {
                romanNumber.append(entry.getKey());
                value -= entry.getValue();
            }
        }
        return romanNumber.toString();
    }

}
