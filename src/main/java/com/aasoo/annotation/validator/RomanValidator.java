package com.aasoo.annotation.validator;

import com.aasoo.annotation.annotation.RomanValidation;
import com.aasoo.annotation.mapper.RomanMapping;
import com.aasoo.annotation.utils.Converter;

import java.lang.reflect.Method;

public class RomanValidator {
    private static Object invokeWithValidation(Object obj, String methodName, String input) {
        try {
            Method method = obj.getClass().getMethod(methodName, String.class);

            if (method.isAnnotationPresent(RomanValidation.class)) {
                // Validate input before invoking -> character-level validation
                for (char c : input.toCharArray()) {
                    if (!RomanMapping.isValidRomanChar(String.valueOf(c))) {
                        throw new IllegalArgumentException("Invalid Roman character: " + c);
                    }
                }

                // Format-level validation
                if (!FormatValidator.isProperRomanFormat(input)) {
                    throw new IllegalArgumentException("Invalid Roman numeral format: " + input);
                }
            }

            return method.invoke(obj, input);

        } catch (Exception e) {
            throw new RuntimeException("Invocation failed: " + e.getMessage(), e);
        }
    }

    public static int convertRomanToInt(String romanNumeral) {
        return (int) RomanValidator.invokeWithValidation(Converter.getInstance(), "romanToInt", romanNumeral);
    }
}
