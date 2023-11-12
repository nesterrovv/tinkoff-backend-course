package edu.hw5.task8;

import edu.exceptions.IncorrectArgumentException;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("ReturnCount") // we need to do 8 return instructions in this validator due to task condition
@Slf4j
public final class Task8Validator {

    private static final String REGEX_1 = "^[01]*[01]([01][01]*)?$";
    private static final String REGEX_2 = "^(0[01]*1|[01]*0)$";
    private static final String REGEX_3 = "^(1*01*0){3,}1*$";
    private static final String REGEX_4 = "^(?!11$|111$)[01]+$";
    private static final String REGEX_5 = "^[01]*1[01]*$";
    private static final String REGEX_6 = "^([^1]*1[^1]*){0,1}0([^1]*1[^1]*){0,1}0[^1]*$";
    private static final String REGEX_7 = "^((?!11)[01])+$";

    private Task8Validator() {}

    public static boolean validate(String input, ValidatorOption validatorOption) {
        try {
            if (input == null || validatorOption == null) {
                throw new IncorrectArgumentException("Input string and validator options cannot be null.");
            }

            switch (validatorOption) {
                case FIRST:
                    return input.matches(REGEX_1);
                case SECOND:
                    return input.matches(REGEX_2);
                case THIRD:
                    return input.matches(REGEX_3);
                case FOURTH:
                    return input.matches(REGEX_4);
                case FIFTH:
                    return input.matches(REGEX_5);
                case SIXTH:
                    return input.matches(REGEX_6);
                case SEVENTH:
                    return input.matches(REGEX_7);
                default:
                    throw new IllegalArgumentException("Unknown ValidatorOption: " + validatorOption);
            }

        } catch (IncorrectArgumentException exception) {
            log.error(exception.getMessage());
            return false;
        }
    }


    enum ValidatorOption {
        FIRST,
        SECOND,
        THIRD,
        FOURTH,
        FIFTH,
        SIXTH,
        SEVENTH,
        EIGHTH
    }

}
