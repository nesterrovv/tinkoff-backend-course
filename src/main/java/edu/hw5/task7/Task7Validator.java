package edu.hw5.task7;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Task7Validator {

    private static final String REGEX_1 = "[01]{2}0[01]*";
    private static final String REGEX_2 = "([01]).*\\1";
    private static final String REGEX_3 = "[01]{1,3}";

    private Task7Validator() {}

    public static boolean validate(String input, ValidatorOption validatorOption) {
        if (input == null || validatorOption == null) {
            log.error("Input string and validator options cannot be null.");
            return false;
        }
        return switch (validatorOption) {
            case FIRST -> input.matches(REGEX_1);
            case SECOND -> input.matches(REGEX_2);
            case THIRD -> input.matches(REGEX_3);
            default -> throw new IllegalArgumentException("Unknown ValidatorOption: " + validatorOption);
        };
    }


    enum ValidatorOption {
        FIRST,
        SECOND,
        THIRD
    }

}
