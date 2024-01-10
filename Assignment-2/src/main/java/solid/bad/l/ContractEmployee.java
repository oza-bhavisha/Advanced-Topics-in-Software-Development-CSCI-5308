package solid.bad.l;

/**
 * This class represents a contract employee.
 * It extends the Employee class.
 */
public class ContractEmployee extends Employee {

    // Constructor for ContractEmployee
    public ContractEmployee(String name, int id) {
        super(name, id);
    }

    /**
     * Calculates the salary for the contract employee.
     * The salary is calculated based on contract employee rules.
     *
     * @return The calculated salary.
     */
    @Override
    public double calculateSalary() {
        // Calculate salary based on contract employee rules
        return getSalary() * 0.8;
    }
}