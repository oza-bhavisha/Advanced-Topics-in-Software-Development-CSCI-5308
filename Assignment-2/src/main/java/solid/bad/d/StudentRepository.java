package solid.bad.d;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a repository for managing students.
 */
public class StudentRepository {
    private final List<Student> students;

    // Constructor of StudentRepository
    public StudentRepository() {
        students = new ArrayList<>();
    }

    /**
     * Adds a student to the repository.
     *
     * @param student The student to be added.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Retrieves a list of all students in the repository.
     *
     * @return The list of all students.
     */
    public List<Student> getAllStudents() {
        return students;
    }

    /**
     * Deletes a student from the repository based on the banner ID.
     *
     * @param bannerId The banner ID of the student to be deleted.
     */
    public void deleteStudent(String bannerId) {
        for (Student student : students) {
            if (student.getBannerId().equals(bannerId)) {
                students.remove(student);
                break;
            }
        }
    }
}