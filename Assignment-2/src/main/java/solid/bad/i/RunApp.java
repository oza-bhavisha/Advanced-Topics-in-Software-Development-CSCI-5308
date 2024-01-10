package solid.bad.i;

import java.util.Scanner;

// Main method to run
public class RunApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****************************************");
        System.out.println("Welcome to Student Management System.....");
        System.out.println("*****************************************");

        // Input student details
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("*****************************************");
        System.out.print("Enter student type (U for undergrad, G for grad): ");
        String type = scanner.nextLine();

        Student student;

        // Create the appropriate student object based on the user input
        if (type.equalsIgnoreCase("U")) {
            student = new UndergraduateStudent(name);
        } else if (type.equalsIgnoreCase("G")) {
            student = new GraduateStudent(name);
        } else {
            System.out.println("Oops.... Invalid student type!");
            return;
        }

        while (true) {
            // Display options for student management
            System.out.println("\nSelect an option:");
            System.out.println("*****************************************");
            System.out.println("1. Register for a course");
            System.out.println("2. Remove a course");
            System.out.println("3. View enrolled courses");
            System.out.println("4. Additional Option for Undergrad Students");
            System.out.println("5. Additional Option for Grad Students");
            System.out.println("0. Exit");
            System.out.println("*******************");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter course name to enroll: ");
                    String enrollCourse = scanner.nextLine();
                    student.registerCourse(enrollCourse);
                    break;
                case 2:
                    System.out.print("Enter course name to drop: ");
                    String dropCourse = scanner.nextLine();
                    student.deregisterCourse(dropCourse);
                    break;
                case 3:
                    student.showCourses();
                    break;
                case 4:
                    if (student instanceof UndergraduateStudent) {
                        ((UndergraduateStudent) student).printScholarshipEligibility();
                    } else {
                        System.out.println("Invalid option for this student type.");
                    }
                    break;
                case 5:
                    if (student instanceof GraduateStudent) {
                        ((GraduateStudent) student).printResearchTopic();
                    } else {
                        System.out.println("Invalid option for this student type.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Oops Invalid choice!");
                    break;
            }
        }
    }
}