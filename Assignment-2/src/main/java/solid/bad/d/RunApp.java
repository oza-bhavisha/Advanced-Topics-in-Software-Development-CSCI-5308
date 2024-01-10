package solid.bad.d;

import java.util.List;
import java.util.Scanner;

// Main method to run
public class RunApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();

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
                    String studentName = sc.nextLine();
                    System.out.print("Enter student's banner id: ");
                    String bannerId = String.valueOf(sc.nextLine());
                    System.out.print("Enter student's age: ");
                    int studentAge = sc.nextInt();
                    studentService.addStudent(studentName, bannerId, studentAge);
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.print("Enter banner id of the student to delete: ");
                    int removeStudent = sc.nextInt();
                    studentService.deleteStudent(String.valueOf(removeStudent));
                    System.out.println("Student deleted successfully!");
                    break;
                case 3:
                    System.out.print("Enter banner id of the student to update: ");
                    String updateBannerId = String.valueOf(sc.nextInt());
                    System.out.print("Enter new banner id: ");
                    String newBannerId = String.valueOf(sc.nextInt());
                    studentService.updateStudentRollNumber(updateBannerId, newBannerId);
                    System.out.println("Student's banner id updated successfully!");
                    break;
                case 4:
                    System.out.print("Enter banner id of the student to update: ");
                    int updateAge = sc.nextInt();
                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();
                    studentService.updateStudentAge(String.valueOf(updateAge), newAge);
                    System.out.println("Student's age updated successfully!");
                    break;
                case 5:
                    List<Student> students = studentService.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("Sorry.... No students found!");
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