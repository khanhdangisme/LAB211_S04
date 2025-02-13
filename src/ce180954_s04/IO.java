/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce180954_s04;

import java.util.Scanner;

/**
 *  S04 - Check student’s data format.
 * @author Le Khanh Dang - CE180954 18/01/2025
 */
public class IO {
    // Create a Scanner object to read user input
    private Scanner sc = new Scanner(System.in);

    /**
     * Validates input for a name that can only contain letters and spaces.
     *
     * @param msg the message to prompt the user
     * @return a valid name input
     */
    public String checkName(String msg) {
        String input; // Declare a variable to store user input
        while (true) { // Start a loop to keep asking for input until valid
            try {
                System.out.print(msg); // Display the prompt message
                input = sc.nextLine().trim(); // Read user input and trim leading/trailing spaces

                // Check if input is empty or contains invalid characters
                if (input.isEmpty() || !input.matches("[a-zA-Z ]+")) {
                    throw new IllegalArgumentException("Name can only contain letters and spaces."); //drop exception
                }

                return input; // Return valid input if no exceptions are thrown
            } catch (IllegalArgumentException e) {
                // Display error message if input is invalid
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Validates input for a class name that can only contain letters and
     * numbers.
     *
     * @param msg the message to prompt the user
     * @return a valid class name input
     */
    public String checkClass(String msg) {
        String input; // Declare a variable to store user input
        while (true) { // Start a loop to keep asking for input until valid
            try {
                System.out.print(msg); // Display the prompt message
                input = sc.nextLine().trim(); // Read user input and trim leading/trailing spaces

                // Check if input is empty or contains invalid characters
                if (input.isEmpty() || !input.matches("[a-zA-Z0-9]+")) {
                    throw new IllegalArgumentException("Class can only contain letters and numbers."); //drop exception
                }

                return input; // Return valid input if no exceptions are thrown
            } catch (IllegalArgumentException e) {
                // Display error message if input is invalid
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Validates input for a score that must be a number between 0 and 10.
     *
     * @param msg the message to prompt the user
     * @return a valid score as a double
     */
    public double checkScore(String msg) {
        double score; // Declare a variable to store the score as a double
        while (true) { // Start a loop to keep asking for input until valid
            try {
                System.out.print(msg); // Display the prompt message
                String input = sc.nextLine().trim(); // Read user input and trim spaces

                score = Double.parseDouble(input); // Try to convert the input to a double

                // Check if the score is out of the valid range
                if (score < 0) {
                    throw new IllegalArgumentException("must be greater than or equal to zero."); //drop exception
                } else if (score > 10) {
                    throw new IllegalArgumentException("must be less than or equal to ten."); //drop exception
                }

                return score; // Return valid score if no exceptions are thrown
            } catch (NumberFormatException e) {
                // Display an error message if the input is not a valid number
                System.out.println(msg.replace(":", "") + "must be a number.");
            } catch (IllegalArgumentException e) {
                // Display an error message if the score is out of range
                System.out.println(msg.replace(":", "") + e.getMessage());
            }
        }
    }

    /**
     * Validates input for a yes/no response. Accepts "Y", "YES", "N", and "NO".
     *
     * @param msg the message to prompt the user
     * @return true for "YES" or "Y", false for "NO" or "N"
     */
    public boolean checkYesNo(String msg) {
        String input; // Declare a variable to store user input
        while (true) { // Start a loop to keep asking for input until valid
            System.out.print(msg); // Display the prompt message with "(Y/N)" appended
            input = sc.nextLine().trim().toUpperCase(); // Read user input, trim spaces, and convert to uppercase

            // Check if input matches valid yes responses
            if (input.equals("YES") || input.equals("Y")) {
                return true; // Return true for "YES" or "Y"
            } // Check if input matches valid no responses
            else if (input.equals("NO") || input.equals("N")) {
                return false; // Return false for "NO" or "N"
            } else {
                // Display an error message for invalid responses
                System.out.println("Invalid input. Please enter YES/Y or NO/N.");
            }
        }
    }
}
