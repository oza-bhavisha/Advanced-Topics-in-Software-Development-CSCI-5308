package solid.bad.l;

/**
 * This class represents an employee.
 * It is an abstract class.
 */
public abstract class Employee {
    private String name;
    private int id;
    private double salary;

    // Constructor for Employee
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Calculates the salary for the employee.
     * This method is abstract and must be implemented by subclasses.
     *
     * @return The calculated salary.
     */
    public abstract double calculateSalary();

    /**
     * Retrieves the name of the employee.
     *
     * @return The name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee.
     *
     * @param name The name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the ID of the employee.
     *
     * @return The ID of the employee.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the employee.
     *
     * @param id The ID to be set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the salary of the employee.
     *
     * @return The salary of the employee.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the employee.
     *
     * @param salary The salary to be set.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
}