package com.aasoo.annotation;

import com.aasoo.annotation.validator.RomanValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Create a Scanner object to read input from the console
        System.out.println("Enter a Roman numeral:"); // Prompt the user to enter a Roman numeral
        String romanNumeral = sc.nextLine().toUpperCase(); // Read the input and convert it to uppercase for consistency
        try {
            int result = RomanValidator.convertRomanToInt(romanNumeral); // Invoke the romanToInt method with validation
            System.out.println("The integer value of the Roman numeral " + romanNumeral + " is: " + result); // Print the result
        } catch (Exception e) {
            System.out.println("Invalid Roman numeral: " + romanNumeral); // Print an error message if the input is invalid
            System.out.println("Error: " + e.getMessage()); // Print the error message from the exception
        } finally {
            sc.close(); // Close the Scanner to prevent resource leaks
        }
    }
}
