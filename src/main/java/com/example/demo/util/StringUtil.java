package com.example.demo.util;

// Unused import
import java.util.List;

public class StringUtil {

    public static String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    // Unused method
    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
