package com.aasoo.annotation;

import com.aasoo.annotation.utils.Converter;
import com.aasoo.annotation.validator.RomanValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RomanConverterTest {

    // Test cases for Roman numeral conversion
    @Test
    public void testValidRomanNumerals() {
        assertEquals(3, RomanValidator.convertRomanToInt("III"));
        assertEquals(4, RomanValidator.convertRomanToInt("IV"));
        assertEquals(9, RomanValidator.convertRomanToInt("IX"));
        assertEquals(58, RomanValidator.convertRomanToInt("LVIII"));
        assertEquals(1994, RomanValidator.convertRomanToInt("MCMXCIV"));
    }

    // Test cases for invalid Roman numeral inputs
    @Test
    public void testInvalidCharacters() {
        Exception ex = assertThrows(RuntimeException.class, () ->
                RomanValidator.convertRomanToInt("AB")
        );
        assertTrue(ex.getCause().getMessage().contains("Invalid Roman character"));
    }

    // Test cases for invalid Roman numeral formats
    @Test
    public void testInvalidRomanFormat_TooManySameChars() {
        Exception ex = assertThrows(RuntimeException.class, () ->
                RomanValidator.convertRomanToInt("IIII")
        );
        assertTrue(ex.getCause().getMessage().contains("Invalid Roman numeral format"));
    }

    // Test cases for invalid Roman numeral formats
    @Test
    public void testInvalidRomanFormat_SubtractiveMisuse() {
        Exception ex = assertThrows(RuntimeException.class, () ->
                RomanValidator.convertRomanToInt("IXCV")
        );
        assertTrue(ex.getCause().getMessage().contains("Invalid Roman numeral format"));
    }

    // Test cases for edge cases
    @Test
    public void testEmptyString() {
        assertEquals(0, RomanValidator.convertRomanToInt(""));
    }

    // Test cases for single character Roman numerals
    @Test
    public void testSingleCharacter() {
        assertEquals(1, RomanValidator.convertRomanToInt("I"));
        assertEquals(1000, RomanValidator.convertRomanToInt("M"));
    }
}
