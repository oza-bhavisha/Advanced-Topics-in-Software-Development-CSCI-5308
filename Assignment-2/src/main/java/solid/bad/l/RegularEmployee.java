package solid.bad.l;

/**
 * This class represents a Regular Employee.
 * It extends the Employee class and provides an implementation for calculating the salary of a regular employee.
 */
public class RegularEmployee extends Employee {
    // Constructor for RegularEmployee
    public RegularEmployee(String name, int id) {
        super(name, id);
    }

    /**
     * Calculates the salary of the regular employee.
     * The salary is calculated by subtracting 1000 from the base salary.
     *
     * @return The calculated salary.
     */
    @Override
    public double calculateSalary() {
        // Calculate salary based on regular employee rules
        return getSalary() - 1000;
    }
}