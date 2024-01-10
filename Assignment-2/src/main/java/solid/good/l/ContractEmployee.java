package solid.good.l;

/**
 * This class represents a contract employee.
 * It extends the Employee class and provides an implementation for calculating the salary of a contract employee.
 */
public class ContractEmployee extends Employee {
    private double salary;

    // Constructor for ContractEmployee
    public ContractEmployee(String name, int id) {
        super(name, id);
    }

    /**
     * Retrieves the salary of the contract employee.
     *
     * @return The salary of the employee.
     */
    @Override
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the contract employee.
     *
     * @param salary The salary to be set.
     */
    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Calculates the salary for the contract employee.
     * The salary is calculated based on contract employee rules.
     *
     * @return The calculated salary.
     */
    @Override
    public double calculateSalary() {
        return salary * 0.8;
    }
}