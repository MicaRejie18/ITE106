import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        String[] studentNames = new String[numberOfStudents];
        double[] averageScores = new double[numberOfStudents];
        char[] letterGrades = new char[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();

            System.out.print("Enter the number of assignments: ");
            int numberOfAssignments = scanner.nextInt();

            double totalScore = 0;
            for (int j = 0; j < numberOfAssignments; j++) {
                System.out.print("Enter score for assignment " + (j + 1) + ": ");
                totalScore += scanner.nextDouble();
            }
            scanner.nextLine();

            averageScores[i] = totalScore / numberOfAssignments;
            letterGrades[i] = calculateLetterGrade(averageScores[i]);
        }

        System.out.println("\nStudent Information:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Name: " + studentNames[i] + ", Average Score: " + averageScores[i] + ", Grade: " + letterGrades[i]);
        }

        scanner.close();
    }

    public static char calculateLetterGrade(double averageScore) {
        if (averageScore >= 90) {
            return 'A';
        } else if (averageScore >= 80) {
            return 'B';
        } else if (averageScore >= 70) {
            return 'C';
        } else if (averageScore >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
