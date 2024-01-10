package solid.bad.d;

/**
 * This class represents a student.
 */
public class Student {
    private final String studentName;
    private String bannerId;
    private int studentAge;

    // Constructor of Student
    public Student(String studentName, String bannerId, int studentAge) {
        this.studentName = studentName;
        this.bannerId = bannerId;
        this.studentAge = studentAge;
    }

    /**
     * Retrieves the name of the student.
     *
     * @return The name of the student.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Retrieves the banner ID of the student.
     *
     * @return The bannerID of the student.
     */
    public String getBannerId() {
        return bannerId;
    }


    /**
     * Retrieves the age of the student.
     *
     * @return The age of the student.
     */
    public int getStudentAge() {
        return studentAge;
    }

    /**
     * Sets the banner ID of the student.
     *
     * @param bannerId The banner ID to be set.
     */
    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    /**
     * Sets the age of the student.
     *
     * @param studentAge The age to be set.
     */
    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }
}