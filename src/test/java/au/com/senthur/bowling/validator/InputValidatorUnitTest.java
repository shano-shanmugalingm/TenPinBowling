package au.com.senthur.bowling.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputValidatorUnitTest {

    @ParameterizedTest
    @NullSource
    void validateInput_shouldReturnFalse_whenInputIsNull(String input) {
        assertFalse(InputValidator.validateInput(input));
    }

    @ParameterizedTest
    @EmptySource
    void validateInput_shouldReturnFalse_whenInputIsEmpty(String input) {
        assertFalse(InputValidator.validateInput(input));
    }

    @Test
    void validateInput_shouldReturnFalse_whenInputLengthIsGreaterThanOne() {
        assertFalse(InputValidator.validateInput("12345"));
    }

    @ParameterizedTest(name = "{index} : valid input: ''{0}''")
    @ValueSource(strings = {"X", "/", "-", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
    void validInput_shouldReturnTrue_whenValidInputsAreProvided(String input) {
        assertTrue(InputValidator.validateInput(input));
    }

    @ParameterizedTest(name = "{index} : invalid input: ''{0}''")
    @ValueSource(strings = {"0", "A", "B", "C", "Y", "%", "*", "Z", "D"})
    void validInput_shouldReturnFalse_whenInValidInputsAreProvided(String input) {
        assertFalse(InputValidator.validateInput(input));
    }

}
