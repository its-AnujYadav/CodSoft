// TASK 5 - Sudent Management System 

import java.util.ArrayList;
import java.util.Scanner;

class StudentManagementApp {
    private String name;
    private int rollNumber;
    private String grade;
    private double cgpa;

    public StudentManagementApp(String name, int rollNumber, String grade, double cgpa) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.cgpa = cgpa;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public double getCgpa() {
        return cgpa;
    }

    // StudentManagementSystem class

    static class StudentManagementSystem {
        private ArrayList<StudentManagementApp> students = new ArrayList<>();

        public void addStudent(StudentManagementApp student) {
            students.add(student);
        }

        public void removeStudent(int rollNumber) {
            students.removeIf(student -> student.getRollNumber() == rollNumber);
        }

        public StudentManagementApp searchStudent(int rollNumber) {
            return students.stream().filter(s -> s.getRollNumber() == rollNumber).findFirst().orElse(null);
        }

        public void displayAllStudents() {
            students.forEach(s -> System.out.println("Name: " + s.getName() + ", Roll Number: " + s.getRollNumber()
                    + ", Grade: " + s.getGrade() + ", CGPA: " + s.getCgpa()));
        }
    }

    // StudentManagementSystemApp class

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "\nStudent Management System\n1. Add Student\n2. Remove Student\n3. Search Student\n4. Display All Students\n5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student roll number: ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter student grade: ");
                    String grade = sc.nextLine();
                    System.out.print("Enter student CGPA: ");
                    double cgpa = sc.nextDouble();
                    sc.nextLine();
                    system.addStudent(new StudentManagementApp(name, rollNumber, grade, cgpa));
                    System.out.println("Student added successfully!");
                }

                case 2 -> {
                    System.out.print("Enter student roll number to remove: ");
                    system.removeStudent(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Student removed successfully!");
                }

                case 3 -> {
                    System.out.print("Enter student roll number to search: ");
                    int searchRollNumber = sc.nextInt();
                    sc.nextLine();
                    StudentManagementApp searchedStudent = system.searchStudent(searchRollNumber);
                    System.out.println(searchedStudent != null
                            ? "Student found:\nName: " + searchedStudent.getName() + ", Roll Number: "
                                    + searchedStudent.getRollNumber() + ", Grade: " + searchedStudent.getGrade()
                                    + ", CGPA: " + searchedStudent.getCgpa()
                            : "Student not found.");
                }

                case 4 -> system.displayAllStudents();

                case 5 -> {
                    System.out.println("Exiting Student Management System. Goodbye!");
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
