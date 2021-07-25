package au.com.senthur.bowling.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsUnitTest {

    @ParameterizedTest
    @NullSource
    void getNum_shouldReturnZero_whenInputIsNull(String input) {
        assertEquals(0, Utils.getNum(input));
    }

    @ParameterizedTest
    @EmptySource
    void getNum_shouldReturnZero_whenInputIsEmpty(String input) {
        assertEquals(0, Utils.getNum(input));
    }

    @Test
    void getNum_shouldReturnZero_whenInputIsNotNumber() {
        assertEquals(0, Utils.getNum("ABC"));
    }

    @Test
    void getNum_shouldReturnConvertedValue_whenInputIsValidNumber() {
        assertEquals(9, Utils.getNum("9"));
    }

}
