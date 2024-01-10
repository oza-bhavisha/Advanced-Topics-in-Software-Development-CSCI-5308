package solid.good.d;

import java.util.List;

/**
 * This interface represents a student repository for managing students.
 */
public interface StudentRepository {

    /**
     * Adds a student to the repository.
     *
     * @param student The student to be added.
     */
    void addStudent(Student student);

    /**
     * Retrieves a list of all students in the repository.
     *
     * @return The list of all students.
     */
    List<Student> getAllStudents();

    /**
     * Deletes a student from the repository based on the banner ID.
     *
     * @param bannerId The banner ID of the student to be deleted.
     */
    void deleteStudent(String bannerId);
}
