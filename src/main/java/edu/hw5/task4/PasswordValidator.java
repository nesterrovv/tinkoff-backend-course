package edu.hw5.task4;

import edu.exceptions.IncorrectArgumentException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class PasswordValidator {

    private static final String PASSWORD_PATTERN = ".*[~!@#$%^&*|].*";

    private PasswordValidator() {}

    public static boolean isValidPassword(String password) {
        try {
            if (password == null) {
                throw new IncorrectArgumentException("Password cannot be null.");
            }
            Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
            Matcher matcher = pattern.matcher(password);
            return matcher.matches();
        } catch (IncorrectArgumentException exception) {
            log.error(exception.getMessage());
            return false;
        }
    }

}
