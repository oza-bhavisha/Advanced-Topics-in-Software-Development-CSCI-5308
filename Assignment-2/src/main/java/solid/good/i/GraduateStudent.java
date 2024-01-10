package solid.good.i;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a graduate student.
 */
public class GraduateStudent implements Student, ResearchTopic {
    private final String name;
    private final List<String> courses;

    /**
     * Constructor of the GraduateStudent class.
     *
     * @param name The name of the graduate student.
     */
    public GraduateStudent(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    /**
     * Registers a course for the graduate student.
     *
     * @param course The course to be registered.
     */
    @Override
    public void registerCourse(String course) {
        courses.add(course);
        System.out.println("*****************************");
        System.out.println("Enrolled in course: " + course);
        System.out.println("*****************************");
    }

    /**
     * Deregisters a course for the graduate student.
     *
     * @param course The course to be deregistered.
     */
    @Override
    public void deregisterCourse(String course) {
        courses.remove(course);
        System.out.println("*****************************");
        System.out.println("Dropped course: " + course);
        System.out.println("*****************************");
    }

    //Shows the courses enrolled by the graduate student.
    @Override
    public void showCourses() {
        System.out.println("*********************************");
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

    // Prints the research topic being conducted by the graduate student.
    @Override
    public void printResearchTopic() {
        System.out.println("******************************************");
        System.out.println(name + " is conducting research on a topic.");
        System.out.println("******************************************");
    }
}