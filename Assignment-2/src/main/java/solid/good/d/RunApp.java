package solid.good.d;

import java.util.List;
import java.util.Scanner;

// Main method to run
public class RunApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRepository studentRepository = new ManageStudentRepository();
        StudentService studentService = new StudentService(studentRepository);

        while (true) {
            // Display options for operation
            System.out.println("*****************************************");
            System.out.println("------- Student Management System -------");
            System.out.println("*****************************************");
            System.out.println("\nSelect an option:");
            System.out.println("*****************************************");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student Banner ID");
            System.out.println("4. Update Student Age");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.println("*****************************************");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student's name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student's banner ID: ");
                    String bannerId = sc.nextLine();
                    System.out.print("Enter student's age: ");
                    int age = sc.nextInt();
                    studentService.addStudent(name, bannerId, age);
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.print("Enter banner ID of the student to remove: ");
                    String removeBannerId = sc.nextLine();
                    studentService.deleteStudent(removeBannerId);
                    System.out.println("Student removed successfully!");
                    break;
                case 3:
                    System.out.print("Enter banner ID of the student to update: ");
                    String updateBannerId = sc.nextLine();
                    System.out.print("Enter new banner ID: ");
                    String newBannerId = sc.nextLine();
                    studentService.updateStudentBannerId(updateBannerId, newBannerId);
                    System.out.println("Student's banner ID updated successfully!");
                    break;
                case 4:
                    System.out.print("Enter banner ID of the student to update: ");
                    String updateAgeBannerId = sc.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();
                    studentService.updateStudentAge(updateAgeBannerId, newAge);
                    System.out.println("Student's age updated successfully!");
                    break;
                case 5:
                    List<Student> students = studentService.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        System.out.println("List of students:");
                        for (Student student : students) {
                            System.out.println("*****************************************");
                            System.out.println("Student Name: " + student.getStudentName());
                            System.out.println("Banner ID: " + student.getBannerId());
                            System.out.println("Student Age: " + student.getStudentAge());
                            System.out.println("*****************************************");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Oops Invalid choice.");
            }
        }
    }
}