package edu.hw5.task5;

import edu.exceptions.IncorrectArgumentException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class RussianLicensePlateValidator {

    private static final String LICENSE_PLATE_PATTERN = "^[АВЕКМНОРСТУХ]{1}\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$";
    private static final Pattern PATTERN = Pattern.compile(LICENSE_PLATE_PATTERN);

    private RussianLicensePlateValidator() {}

    public static boolean isValidLicensePlate(String licensePlate) {
        try {
            if (licensePlate == null) {
                throw new IncorrectArgumentException("License plate string representation cannot be null.");
            }
            Matcher matcher = PATTERN.matcher(licensePlate);
            return matcher.matches();
        } catch (IncorrectArgumentException exception) {
            log.error(exception.getMessage());
            return false;
        }
    }

}
