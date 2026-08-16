import java.util.ArrayList;
import java.util.Scanner;

public class UniversityCourseManagement {

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Instructor> instructors = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Enrollment> enrollments = new ArrayList<>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println("   UNIVERSITY COURSE MANAGEMENT");
            System.out.println("======================================");
            System.out.println("1. Add Student");
            System.out.println("2. Add Instructor");
            System.out.println("3. Add Course");
            System.out.println("4. Enroll Student in Course");
            System.out.println("5. Display Students");
            System.out.println("6. Display Instructors");
            System.out.println("7. Display Courses");
            System.out.println("8. Display Enrollments");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    addInstructor();
                    break;

                case 3:
                    addCourse();
                    break;

                case 4:
                    enrollStudent();
                    break;

                case 5:
                    displayStudents();
                    break;

                case 6:
                    displayInstructors();
                    break;

                case 7:
                    displayCourses();
                    break;

                case 8:
                    displayEnrollments();
                    break;

                case 9:
                    System.out.println("\nThank you for using the system!");
                    break;

                default:
                    System.out.println("\nInvalid choice!");
            }

        } while (choice != 9);

        input.close();
    }

    public static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = input.nextInt();

        input.nextLine();

        System.out.print("Enter Student Name: ");
        String name = input.nextLine();

        System.out.print("Enter Student Email: ");
        String email = input.nextLine();

        Student student = new Student(id, name, email);

        students.add(student);

        System.out.println("\nStudent added successfully!");
    }

    public static void addInstructor() {

        System.out.print("Enter Instructor ID: ");
        int id = input.nextInt();

        input.nextLine();

        System.out.print("Enter Instructor Name: ");
        String name = input.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = input.nextLine();

        Instructor instructor =
                new Instructor(id, name, specialization);

        instructors.add(instructor);

        System.out.println("\nInstructor added successfully!");
    }

    public static void addCourse() {

        System.out.print("Enter Course ID: ");
        int id = input.nextInt();

        input.nextLine();

        System.out.print("Enter Course Name: ");
        String name = input.nextLine();

        System.out.print("Enter Credit Hours: ");
        int creditHours = input.nextInt();

        Course course =
                new Course(id, name, creditHours);

        courses.add(course);

        System.out.println("\nCourse added successfully!");
    }

    public static void enrollStudent() {

        if (students.isEmpty() || courses.isEmpty()) {
            System.out.println(
                "\nPlease add a student and a course first."
            );
            return;
        }

        System.out.print("Enter Student ID: ");
        int studentId = input.nextInt();

        System.out.print("Enter Course ID: ");
        int courseId = input.nextInt();

        Student selectedStudent = null;
        Course selectedCourse = null;

        for (Student student : students) {

            if (student.getStudentId() == studentId) {
                selectedStudent = student;
                break;
            }
        }

        for (Course course : courses) {

            if (course.getCourseId() == courseId) {
                selectedCourse = course;
                break;
            }
        }

        if (selectedStudent == null) {
            System.out.println("\nStudent not found!");
            return;
        }

        if (selectedCourse == null) {
            System.out.println("\nCourse not found!");
            return;
        }

        Enrollment enrollment =
                new Enrollment(selectedStudent, selectedCourse);

        enrollments.add(enrollment);

        System.out.println("\nStudent enrolled successfully!");
    }

    public static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo students available.");
            return;
        }

        System.out.println("\n========== STUDENTS ==========");

        for (Student student : students) {
            student.displayStudent();
            System.out.println("------------------------------");
        }
    }

    public static void displayInstructors() {

        if (instructors.isEmpty()) {
            System.out.println("\nNo instructors available.");
            return;
        }

        System.out.println("\n========= INSTRUCTORS =========");

        for (Instructor instructor : instructors) {
            instructor.displayInstructor();
            System.out.println("-------------------------------");
        }
    }

    public static void displayCourses() {

        if (courses.isEmpty()) {
            System.out.println("\nNo courses available.");
            return;
        }

        System.out.println("\n========== COURSES ==========");

        for (Course course : courses) {
            course.displayCourse();
            System.out.println("-----------------------------");
        }
    }

    public static void displayEnrollments() {

        if (enrollments.isEmpty()) {
            System.out.println("\nNo enrollments available.");
            return;
        }

        System.out.println("\n======== ENROLLMENTS ========");

        for (Enrollment enrollment : enrollments) {
            enrollment.displayEnrollment();
        }
    }
}
