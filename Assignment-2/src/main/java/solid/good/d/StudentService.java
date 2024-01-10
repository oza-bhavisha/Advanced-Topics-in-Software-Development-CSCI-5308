package solid.good.d;

import java.util.List;

/**
 * This class provides services related to student management.
 */
public class StudentService {
    private final StudentRepository studentRepository;

    // Constructor of StudentService
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Adds a new student to the student repository.
     *
     * @param studentName The name of the student.
     * @param bannerId The banner ID of the student.
     * @param studentAge The age of the student.
     */
    public void addStudent(String studentName, String bannerId, int studentAge) {
        Student student = new Student(studentName, bannerId, studentAge);
        studentRepository.addStudent(student);
    }

    /**
     * Retrieves a list of all students from the student repository.
     *
     * @return The list of all students.
     */
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    /**
     * Removes a student from the student repository based on the banner ID.
     *
     * @param bannerId The banner ID of the student to be removed.
     */
    public void deleteStudent(String bannerId) {
        studentRepository.deleteStudent(bannerId);
    }

    /**
     * Updates the banner ID of a student in the student repository.
     *
     * @param bannerId The current banner ID of the student.
     * @param newBannerId The new banner ID to be updated.
     */
    public void updateStudentBannerId(String bannerId, String newBannerId) {
        List<Student> students = studentRepository.getAllStudents();
        for (Student student : students) {
            if (student.getBannerId().equals(bannerId)) {
                student.setBannerId(newBannerId);
                break;
            }
        }
    }

    /**
     * Updates the age of a student in the student repository.
     *
     * @param bannerId The banner ID of the student.
     * @param newStudentAge The new age to be updated.
     */
    public void updateStudentAge(String bannerId, int newStudentAge) {
        List<Student> students = studentRepository.getAllStudents();
        for (Student student : students) {
            if (student.getBannerId().equals(bannerId)) {
                student.setStudentAge(newStudentAge);
                break;
            }
        }
    }
}