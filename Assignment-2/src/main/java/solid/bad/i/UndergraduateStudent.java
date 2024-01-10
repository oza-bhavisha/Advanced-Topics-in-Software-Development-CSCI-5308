package solid.bad.i;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an undergraduate student.
 */
public class UndergraduateStudent implements Student {
    private final String name;
    private final List<String> courses;

    /**
     * Constructor of the UndergraduateStudent class.
     *
     * @param name The name of the undergraduate student.
     */
    public UndergraduateStudent(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    /**
     * Registers a course for the undergraduate student.
     *
     * @param course The course to be registered.
     */
    @Override
    public void registerCourse(String course) {
        courses.add(course);
        System.out.println("*****************************");
        System.out.println("Enrolled in course: " + course);
    }

    /**
     * Deregisters a course for the undergraduate student.
     *
     * @param course The course to be deregistered.
     */
    @Override
    public void deregisterCourse(String course) {
        courses.remove(course);
        System.out.println("**************************");
        System.out.println("Dropped course: " + course);
    }

    // Shows the courses enrolled by the undergraduate student.
    @Override
    public void showCourses() {
        System.out.println("*****************************");
        System.out.println("Courses enrolled by " + name + ":");
        if (courses.isEmpty()) {
            System.out.println("********************");
            System.out.println("No courses enrolled.");
            System.out.println("********************");
        } else {
            for (String course : courses) {
                System.out.println(course);
            }
        }
    }

    // Prints the scholarship eligibility of the undergraduate student.
    public void printScholarshipEligibility() {
        System.out.println("**************************************");
        System.out.println(name + " is eligible for a scholarship.");
        System.out.println("**************************************");
    }
}