package solid.good.l;

/**
 * This class represents a Regular Employee.
 * It extends the Employee class and provides an implementation for calculating the salary of a regular employee.
 */
public class RegularEmployee extends Employee {
    private double salary;

    // Constructor for RegularEmployee
    public RegularEmployee(String name, int id) {
        super(name, id);
    }

    /**
     * Retrieves the salary of the regular employee.
     *
     * @return The salary of the employee.
     */
    @Override
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the regular employee.
     *
     * @param salary The salary to be set.
     */
    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Calculates the salary of the regular employee.
     * The salary is calculated by subtracting 1000 from the base salary.
     *
     * @return The calculated salary.
     */
    @Override
    public double calculateSalary() {
        return salary - 1000;
    }
}