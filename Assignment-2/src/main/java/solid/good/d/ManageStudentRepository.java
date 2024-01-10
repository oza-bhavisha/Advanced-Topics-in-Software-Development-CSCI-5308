package solid.good.d;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a student repository implementation for managing students.
 */
public class ManageStudentRepository implements StudentRepository {
    private final List<Student> students;

    public ManageStudentRepository() {
        students = new ArrayList<>();
    }

    /**
     * Adds a student to the repository.
     *
     * @param student The student to be added.
     */
    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Retrieves a list of all students in the repository.
     *
     * @return The list of all students.
     */
    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    /**
     * Deletes a student from the repository based on the banner ID.
     *
     * @param bannerId The banner ID of the student to be deleted.
     */
    @Override
    public void deleteStudent(String bannerId) {
        students.removeIf(student -> student.getBannerId().equals(bannerId));
    }
}