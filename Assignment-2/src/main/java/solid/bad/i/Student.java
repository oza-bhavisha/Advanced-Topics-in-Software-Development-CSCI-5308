package solid.bad.i;

/**
 * This interface represents a student.
 */
public interface Student {
    /**
     * Registers a course for the student.
     *
     * @param course The course to be registered.
     */
    void registerCourse(String course);

    /**
     * Deregisters a course for the student.
     *
     * @param course The course to be deregistered.
     */
    void deregisterCourse(String course);

    // Shows the courses enrolled by the student.
    void showCourses();
}