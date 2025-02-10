package org.example;
import java.util.ArrayList;
import java.util.List;

// Abstract CourseType Class
abstract class CourseType {
    private String courseName;
    private String instructor;

    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public abstract void displayCourseDetails();
}

// Exam-Based Course
class ExamCourse extends CourseType {
    private int examWeightage; // Percentage of final grade from exams

    public ExamCourse(String courseName, String instructor, int examWeightage) {
        super(courseName, instructor);
        this.examWeightage = examWeightage;
    }

    public int getExamWeightage() {
        return examWeightage;
    }

    @Override
    public void displayCourseDetails() {
        System.out.println("Exam-Based Course: " + getCourseName() +
                ", Instructor: " + getInstructor() +
                ", Exam Weightage: " + examWeightage + "%");
    }
}

// Assignment-Based Course
class AssignmentCourse extends CourseType {
    private int assignmentCount;

    public AssignmentCourse(String courseName, String instructor, int assignmentCount) {
        super(courseName, instructor);
        this.assignmentCount = assignmentCount;
    }

    public int getAssignmentCount() {
        return assignmentCount;
    }

    @Override
    public void displayCourseDetails() {
        System.out.println("Assignment-Based Course: " + getCourseName() +
                ", Instructor: " + getInstructor() +
                ", Assignments: " + assignmentCount);
    }
}

// Research-Based Course
class ResearchCourse extends CourseType {
    private String researchArea;

    public ResearchCourse(String courseName, String instructor, String researchArea) {
        super(courseName, instructor);
        this.researchArea = researchArea;
    }

    public String getResearchArea() {
        return researchArea;
    }

    @Override
    public void displayCourseDetails() {
        System.out.println("Research-Based Course: " + getCourseName() +
                ", Instructor: " + getInstructor() +
                ", Research Area: " + researchArea);
    }
}

// Generic Course Class
class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    public void display() {
        courseType.displayCourseDetails();
    }
}

// Department Class to Store Courses
class Department<T extends CourseType> {
    private String departmentName;
    private List<Course<T>> courses = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addCourse(Course<T> course) {
        courses.add(course);
    }

    public List<Course<T>> getCourses() {
        return courses;
    }

    public void displayCourses() {
        System.out.println("\nDepartment: " + departmentName);
        for (Course<T> course : courses) {
            course.display();
        }
    }

    // Wildcard method to display all courses regardless of type
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.displayCourseDetails();
        }
    }
}

// Main Class for Testing
public class UniversityCourseSystem {
    public static void main(String[] args) {
        // Creating Departments
        Department<ExamCourse> scienceDepartment = new Department<>("Science Department");
        Department<AssignmentCourse> artsDepartment = new Department<>("Arts Department");
        Department<ResearchCourse> engineeringDepartment = new Department<>("Engineering Department");

        // Creating Courses
        ExamCourse physicsExam = new ExamCourse("Physics 101", "Dr. Smith", 70);
        AssignmentCourse historyAssignment = new AssignmentCourse("History 201", "Dr. Brown", 5);
        ResearchCourse aiResearch = new ResearchCourse("AI Research", "Dr. Johnson", "Artificial Intelligence");

        // Wrapping Courses inside Generic Course Class
        Course<ExamCourse> physicsCourse = new Course<>(physicsExam);
        Course<AssignmentCourse> historyCourse = new Course<>(historyAssignment);
        Course<ResearchCourse> aiCourse = new Course<>(aiResearch);

        // Adding Courses to Departments
        scienceDepartment.addCourse(physicsCourse);
        artsDepartment.addCourse(historyCourse);
        engineeringDepartment.addCourse(aiCourse);

        // Display Courses in Each Department
        scienceDepartment.displayCourses();
        artsDepartment.displayCourses();
        engineeringDepartment.displayCourses();

        // Wildcard Method to display all courses
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(physicsExam);
        allCourses.add(historyAssignment);
        allCourses.add(aiResearch);

        System.out.println("\nAll Courses:");
        Department.displayAllCourses(allCourses);
    }
}
