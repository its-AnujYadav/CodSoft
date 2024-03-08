//TASK 2 - Student Grade Calculator

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int noSub = sc.nextInt();     // Taking number of subject from user

        int totalMarks = 0;
        for (int i = 1; i <= noSub; i++) {
            System.out.printf("Enter marks for Subject %d (out of 100): ", i);
            int subMarks = sc.nextInt();

            if (subMarks < 0 || subMarks > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100.");
                return;
            }

            totalMarks += subMarks;
        }



        double avgPer = (double) totalMarks / noSub;

        char grade;
        if (avgPer >= 90) {
            grade = 'A';
        } else if (avgPer >= 80) {
            grade = 'B';
        } else if (avgPer >= 70) {
            grade = 'C';
        } else if (avgPer >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks + " / " + (100*noSub));
        System.out.println("Average Percentage: " + avgPer + "%");
        System.out.println("Grade: " + grade);

        
    }
}
