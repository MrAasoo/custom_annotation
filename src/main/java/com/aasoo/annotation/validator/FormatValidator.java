package com.aasoo.annotation.validator;

public class FormatValidator {
    // Valid Roman numerals from 1 to 3999
    private static final String ROMAN_REGEX = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

    public static boolean isProperRomanFormat(String s) {
        return s.matches(ROMAN_REGEX);
    }
}
