package com.aasoo.annotation.utils;

import com.aasoo.annotation.annotation.RomanValidation;
import com.aasoo.annotation.mapper.RomanMapping;

public class Converter {

    private Converter() {
    }

    public static Converter getInstance() {
        return new Converter();
    }

    /**
     * Converts a Roman numeral string to an integer.
     *
     * @param s the Roman numeral string
     * @return the integer value of the Roman numeral
     */
    @RomanValidation
    public int romanToInt(String s) {
        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            String ch = String.valueOf(s.charAt(i));
            int curr = RomanMapping.getRomanValue(ch);

            if (curr < prev) {
                total -= curr;
            } else {
                total += curr;
            }

            prev = curr;
        }

        return total;
    }
}
