package solid.bad.l;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an Employee Management System.
 * It manages a list of employees and provides operations to add employees, calculate salaries, and display employee information.
 */
public class EmployeeManagementSystem {
    private final List<Employee> employees;

    // Constructor for EmployeeManagementSystem
    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
    }

    /**
     * Adds an employee to the system.
     *
     * @param employee The employee to be added.
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee.getName());
    }

    /**
     * Calculates the salary for the employee with the specified ID.
     *
     * @param empId The ID of the employee.
     * @return The calculated salary.
     */
    public double calculateSalary(int empId) {
        for (Employee employee : employees) {
            if (employee.getId() == empId) {
                return employee.calculateSalary();
            }
        }
        return 0.0;
    }

    //Displays the information of all employees in the system.
    public void displayAllEmployees() {
        System.out.println("**************");
        System.out.println("Employee List:");
        System.out.println("**************");
        for (Employee employee : employees) {
            System.out.println("*****************************************");
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee Salary: " + employee.getSalary());
            System.out.println("*****************************************");
        }
    }
}