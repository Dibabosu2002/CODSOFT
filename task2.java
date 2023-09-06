import java.util.Scanner;
public class task2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of subjects that you appeared for: ");
        int numSub = scanner.nextInt();
        int[] subMarks = new int[numSub];
        int totalMarks = 0;
        for (int i = 0; i < numSub; i++) {
            System.out.print("Enter the marks you obtained in each subject: " + (i + 1) + " (out of 100): ");
            subMarks[i] = scanner.nextInt();
            totalMarks += subMarks[i];
        }
        double avgPer = (double) totalMarks / (numSub * 100) * 100;
        String grade = GradeCalc(avgPer);
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", avgPer);
        System.out.println("Grade: " + grade);
        scanner.close();
    }
    public static String GradeCalc(double avgPer) {
        if (avgPer >= 90) {
            return "A+";
        } else if (avgPer >= 80) {
            return "A";
        } else if (avgPer >= 70) {
            return "B";
        } else if (avgPer >= 60) {
            return "C";
        } else if (avgPer >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
