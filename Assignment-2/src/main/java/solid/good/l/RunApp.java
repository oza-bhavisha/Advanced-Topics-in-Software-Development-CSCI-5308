package solid.good.l;

import java.util.Scanner;

// Main method to run
public class RunApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        while (true) {
            System.out.println("*****************************************");
            System.out.println("------- Employee Management System -------");
            System.out.println("*****************************************");
            System.out.println("\nSelect an option:");
            System.out.println("*****************************************");
            System.out.println("1. Add Employee");
            System.out.println("2. Calculate Salary");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.println("*****************************************");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the employee type (1 for Regular, 2 for Contract): ");
                    int type = scanner.nextInt();
                    System.out.print("Enter the employee's name: ");
                    String name = scanner.next();
                    System.out.print("Enter the employee's ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter the employee's salary: ");
                    double salary = scanner.nextDouble();

                    if (type == 1) {
                        RegularEmployee employee = new RegularEmployee(name, id);
                        employee.setSalary(salary);
                        system.addEmployee(employee);
                    } else if (type == 2) {
                        ContractEmployee employee = new ContractEmployee(name, id);
                        employee.setSalary(salary);
                        system.addEmployee(employee);
                    } else {
                        System.out.println("Oops.. Invalid employee type!");
                    }
                    break;
                case 2:
                    System.out.print("Enter the employee's ID: ");
                    int empId = scanner.nextInt();
                    double calculatedSalary = system.calculateSalary(empId);
                    System.out.println("Calculated Salary of the employee is: " + calculatedSalary);
                    break;
                case 3:
                    system.displayAllEmployees();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Oops Invalid choice.");
                    break;
            }
        }
    }
}