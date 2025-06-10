package com.aasoo.annotation.mapper;

import com.aasoo.annotation.annotation.RomanValue;

import java.util.HashMap;
import java.util.Map;

public class RomanMapping {
    @RomanValue(1)
    public static final String I = "I";

    @RomanValue(5)
    public static final String V = "V";

    @RomanValue(10)
    public static final String X = "X";

    @RomanValue(50)
    public static final String L = "L";

    @RomanValue(100)
    public static final String C = "C";

    @RomanValue(500)
    public static final String D = "D";

    @RomanValue(1000)
    public static final String M = "M";

    public static final Map<String, Integer> romanToIntMap = new HashMap<>();

    static {
        // Use reflection to populate map from annotations
        for (var field : RomanMapping.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(RomanValue.class)) {
                try {
                    RomanValue annotation = field.getAnnotation(RomanValue.class);
                    String roman = (String) field.get(null);
                    romanToIntMap.put(roman, annotation.value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isValidRomanChar(String ch) {
        return romanToIntMap.containsKey(ch);
    }

    public static int getRomanValue(String ch) {
        return romanToIntMap.getOrDefault(ch, 0);
    }
}
