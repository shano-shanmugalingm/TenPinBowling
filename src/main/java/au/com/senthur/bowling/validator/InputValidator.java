package au.com.senthur.bowling.validator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class InputValidator {

    private static final Pattern VALID_PATTERN = Pattern.compile("^[1-9\\/X-]+$");

    public static boolean validateInput(String input) {

        if (Objects.isNull(input) || input.length() != 1) {
            return false;
        }

        Matcher matcher = VALID_PATTERN.matcher(input);
        return matcher.matches();
    }

}
