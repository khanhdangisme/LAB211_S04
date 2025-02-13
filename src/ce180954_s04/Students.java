/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce180954_s04;

import java.util.ArrayList;

/**
 * S04 - Check student’s data format.
 *
 * @author Le Khanh Dang - CE180954 18/01/2025
 */
public class Students {

    private final ArrayList<Students> list = new ArrayList<>(); // A list to store multiple student objects
    private final String studentName; // The name of the student
    private final String studentClass; // The class of the student
    private final double math; // The math score of the student
    private final double physical; // The physical score of the student
    private final double chemistry; // The chemistry score of the student
    private double avg; // The average score of the student
    private String type; // The type or grade category of the student

    /**
     * Constructor to initialize a student's details
     *
     * @param studentName the name of the student
     * @param studentClass the class of the student
     * @param math the math score of the student
     * @param physical the physical score of the student
     * @param chemistry the chemistry score of the student
     */
    public Students(String studentName, String studentClass, double math, double physical, double chemistry) {
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
        this.avg = 0;   // Default average is 0
        this.type = null;   // Default type is null
    }

    /**
     * Adds a student to the list and calculates their average and type
     *
     * @param newStudent the student object to add to the list
     */
    public void addStudent(Students newStudent) {
        newStudent.calculateAvg();  // Calculate average score
        newStudent.calculateType();  // Determine classification type
        list.add(newStudent);   // Add student to the list
    }

    /**
     * Calculates and returns the average score
     *
     * @return the calculated average score
     */
    public double calculateAvg() {
        avg = (math + physical + chemistry) / 3.0;  // Calculate the mean of three scores
        return avg;
    }

    /**
     * Determines the student's type based on their average score
     */
    public void calculateType() {
        if (avg > 7.5) {    // Average greater than 7.5 is type A
            type = "A";
        } else if (avg >= 6) {  // Average between 6 and 7.5 is type B
            type = "B";
        } else if (avg >= 4) {  // Average between 4 and 6 is type C
            type = "C";
        } else {    // Average below 4 is type D
            type = "D";
        }
    }

    /**
     * Displays information about all students in the list
     */
    public void showInfo() {
        int count = 1;  // Counter for numbering students
        for (Students s : list) {
            System.out.println("------ Student" + count++ + " Info ------");    // Student header
            System.out.println("Name:" + s.studentName);    // Display name
            System.out.println("Classes:" + s.studentClass);    // Display class
            System.out.printf("AVG:%.1f\n", s.avg);  // Display average
            System.out.println("Type:" + s.type);   // Display type
        }
    }

    /**
     * Calculates and displays the percentage of students in each classification
     * type
     */
    public void calculateClass() {
        int countA = 0;  // Counter for type A
        int countB = 0;  // Counter for type B
        int countC = 0;  // Counter for type C
        int countD = 0;  // Counter for type D

        for (Students s : list) {
            switch (s.type) {
                case "A":
                    // Count type A students
                    countA++;
                    break;
                case "B":
                    // Count type B students
                    countB++;
                    break;
                case "C":
                    // Count type C students
                    countC++;
                    break;
                case "D":
                    // Count type D students
                    countD++;
                    break;
                default:
                    break;
            }
        }

        // Display classification percentages
        System.out.println("--------Classification Info -----");
        System.out.printf("A:%.1f%%\n", (countA * 100.0) / list.size());    // Percentage of type A
        System.out.printf("B:%.1f%%\n", (countB * 100.0) / list.size());    // Percentage of type B
        System.out.printf("C:%.1f%%\n", (countC * 100.0) / list.size());    // Percentage of type C
        System.out.printf("D:%.1f%%\n", (countD * 100.0) / list.size());    // Percentage of type D
    }

    /**
     * Displays all student information and classification statistics
     */
    public void showAll() {
        showInfo();     // Display student details
        calculateClass();   // Display classification statistics
    }

    /**
     * Checks if a student's name exists in the list.
     *
     * @param name the name to check
     * @return true if the name exists, false otherwise
     */
    public boolean checkExist(String name) {
        for (Students s : list) { // Loop through the list of students
            if (s.studentName.equalsIgnoreCase(name)) { // Compare names (case-insensitive)
                return true; // Name exists
            }
        }
        return false; // Name does not exist
    }
}
