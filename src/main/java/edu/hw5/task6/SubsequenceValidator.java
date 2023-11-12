package edu.hw5.task6;

import edu.exceptions.IncorrectArgumentException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class SubsequenceValidator {

    private SubsequenceValidator() {}

    public static boolean isSubsequence(String s, String t) {
        try {
            if (s == null || t == null) {
                throw new IncorrectArgumentException("s and t cannot be null.");
            }
            if (s.isEmpty() && !t.isEmpty()) {
                throw new IncorrectArgumentException("s cannot be an empty string.");
            }
            String patternString = ".*" + s.chars().mapToObj(c -> (char) c).collect(StringBuilder::new,
                StringBuilder::append, StringBuilder::append
            ) + ".*";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(t);

            return matcher.matches();
        } catch (IncorrectArgumentException exception) {
            log.error(exception.getMessage());
            return false;
        }
    }

}
