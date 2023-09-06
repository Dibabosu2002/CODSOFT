import java.util.ArrayList;
import java.util.Scanner;
class Student {
    private int rollNum;
    private String name;
    private String grade;
    public Student(int rollNum, String name, String grade) {
        this.rollNum = rollNum;
        this.name = name;
        this.grade = grade;
    }
    public int getrollNum() {
        return rollNum;
    }
    public String getName() {
        return name;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Roll Number: " + rollNum + "\nName: " + name + "\nGrade: " + grade;
    }
    public void setrollNum(int nxtrollNum) {
    }
}
class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private int nxtrollNum = 1;
    public void addStudent(Student student) {
        student.setrollNum(nxtrollNum);
        students.add(student);
        nxtrollNum++;
    }
    public boolean remoStud(int rollNum) {
        for (Student student : students) {
            if (student.getrollNum() == rollNum) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }
    public Student searchStudent(int rollNum) {
        for (Student student : students) {
            if (student.getrollNum() == rollNum) {
                return student;
            }
        }
        return null;
    }
    public void dispallStud() {
        for (Student student : students) {
            System.out.println(student);
            System.out.println();
        }
    }
}
public class task5
{
    public static void main(String[] args)
    {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("Student Management System:");
            System.out.println("1. Add Student:");
            System.out.println("2. Remove Student:");
            System.out.println("3. Search Student:");
            System.out.println("4. Display All Students:");
            System.out.println("5. Exit from System:");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1:
                    System.out.print("Enter the student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the student's grade: ");
                    String grade = scanner.nextLine();
                    Student newStudent = new Student(-1, name, grade);
                    sms.addStudent(newStudent);
                    System.out.println("Student that has been added with the Roll Number: " + newStudent.getrollNum());
                    break;
                case 2:
                    System.out.print("Enter the Roll Number to remove students: ");
                    int rollNumToRemove = scanner.nextInt();
                    scanner.nextLine();
                    if (sms.remoStud(rollNumToRemove))
                    {
                        System.out.println("The Student has been removed successfully.");
                    } else
                    {
                        System.out.println("The Student has not been found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter the Roll Number to search for the very student: ");
                    int rollNumToSearch = scanner.nextInt();
                    scanner.nextLine();
                    Student searchedStudent = sms.searchStudent(rollNumToSearch);
                    if (searchedStudent != null)
                    {
                        System.out.println("The Student has been found.");
                        System.out.println(searchedStudent);
                    } else
                    {
                        System.out.println("The Student has not been found!");
                    }
                    break;
                case 4:
                    sms.dispallStud();
                    break;
                case 5:
                    System.out.println("Exiting the Student Management System (SMS).");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your choice is Invalid! Please select a valid option.");
            }
        }
    }
}
