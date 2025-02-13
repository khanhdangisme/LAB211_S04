/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce180954_s04;

/**
 * S04 - Check student’s data format.
 *
 * @author Le Khanh Dang - CE180954 18/01/2025
 */
public class CE180954_S04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of the IO class for input validation
        IO io = new IO();

        // Create an instance of the Students class to manage the list of students
        Students students = new Students(null, null, 0, 0, 0);

        // Start an infinite loop for adding students
        while (true) {
            // Display the program header
            System.out.println("====== Management Student Program ======");

            // Prompt user for student name and validate the input
            String name = io.checkName("Name: ");

            // Check if the name already exists in the list
            if (students.checkExist(name)) { 
                // Inform the user
                System.out.println("This name already exists. Please enter a different name."); 
                // Skip the current iteration and prompt the user again
                continue; 
            }

            // Prompt user for student class and validate the input
            String studentClass = io.checkClass("Classes: ");

            // Prompt user for Math score and validate the input
            double math = io.checkScore("Math: ");

            // Prompt user for Physical score and validate the input
            double physical = io.checkScore("Physica: ");

            // Prompt user for Chemistry score and validate the input
            double chemistry = io.checkScore("Chemistry: ");

            // Create a new student object with the provided data
            Students newStudent = new Students(name, studentClass, math, physical, chemistry);

            // Add the new student to the list and calculate their average and type
            students.addStudent(newStudent);

            // Ask the user if they want to add another student
            boolean continueProgram = io.checkYesNo("Do you want to enter more student information?(Y/N): ");

            // If the user chooses "No", exit the loop and end the program
            if (!continueProgram) {
                System.out.println("Exiting the program. Goodbye!");
                break; // Break out of the loop
            }
        }

        // After exiting the loop, display all student information and statistics
        students.showAll();
    }
}
