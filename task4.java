import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private List<Student> enrolledStudents;
    public Course(String courseCode, String title, String description, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }
    public String getCourseCode() {
        return courseCode;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getEnrollmentCount() {
        return enrolledStudents.size();
    }
    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        } else {
            return false;
        }
    }
    public boolean dropStudent(Student student) {
        return enrolledStudents.remove(student);
    }
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
    @Override
    public String toString() {
        return "Course Code: " + courseCode + "\nTitle: " + title + "\nDescription: " + description +
                "\nCapacity: " + capacity + "\nEnrolled Students: " + enrolledStudents.size();
    }
}
class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;
    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
    public int getStudentID() {
        return studentID;
    }
    public String getName() {
        return name;
    }
    public boolean registerForCourse(Course course) {
        if (!registeredCourses.contains(course) && course.enrollStudent(this)) {
            registeredCourses.add(course);
            return true;
        } else {
            return false;
        }
    }
    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course) && course.dropStudent(this)) {
            registeredCourses.remove(course);
            return true;
        } else {
            return false;
        }
    }
    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }
    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name + "\nRegistered Courses: " + registeredCourses.size();
    }
}
public class task4 {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Course Registration System:");
            System.out.println("1. Add a Course.");
            System.out.println("2. Register Student.");
            System.out.println("3. Drop Student from a Course.");
            System.out.println("4. Display the Course List.");
            System.out.println("5. Display the Student List.");
            System.out.println("6. Exit form System.");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Course Code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Capacity: ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine();
                    Course course = new Course(courseCode, title, description, capacity);
                    courses.add(course);
                    break;
                case 2:
                    System.out.print("Enter your Student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    Student student = new Student(studentID, studentName);
                    students.add(student);
                    System.out.println("Available Courses:");
                    for (int i = 0; i < courses.size(); i++) {
                        Course availableCourse = courses.get(i);
                        System.out.println(i + 1 + ". " + availableCourse.getCourseCode() + " - " + availableCourse.getTitle());
                    }
                    System.out.print("Enter the course number to register for: ");
                    int courseNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (courseNumber >= 1 && courseNumber <= courses.size()) {
                        Course selectedCourse = courses.get(courseNumber - 1);
                        if (student.registerForCourse(selectedCourse)) {
                            System.out.println("Registration is Successful!");
                        } else {
                            System.out.println("Registration has failed. Course is full or already registered.");
                        }
                    } else {
                        System.out.println("Course selection is Invalid!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID for a course drop: ");
                    int studentToDropID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Course Code to drop from: ");
                    String courseToDropCode = scanner.nextLine();
                    Student studentToDrop = null;
                    for (Student s : students) {
                        if (s.getStudentID() == studentToDropID) {
                            studentToDrop = s;
                            break;
                        }
                    }
                    Course courseToDrop = null;
                    for (Course c : courses) {
                        if (c.getCourseCode().equalsIgnoreCase(courseToDropCode)) {
                            courseToDrop = c;
                            break;
                        }
                    }
                    if (studentToDrop != null && courseToDrop != null) {
                        if (studentToDrop.dropCourse(courseToDrop)) {
                            System.out.println("Course drop is Successful!");
                        } else {
                            System.out.println("Course drop failed. Student not registered or unable to drop.");
                        }
                    } else {
                        System.out.println("Invalid student or course.");
                    }
                    break;
                case 4:
                    System.out.println("Course List:");
                    for (Course c : courses) {
                        System.out.println(c);
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("Student List:");
                    for (Student s : students) {
                        System.out.println(s);
                        System.out.println();
                    }
                    break;
                case 6:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
