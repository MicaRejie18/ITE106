import java.util.Scanner;
import java.util.Arrays;

public class StudentGradebookWithArrayProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        System.out.print("Enter the number of assignments: ");
        int numAssignments = scanner.nextInt();

        String[] studentNames = new String[numStudents];
        double[][] grades = new double[numStudents][numAssignments];
        double[] averageScores = new double[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = scanner.next();
            double sum = 0;
            for (int j = 0; j < numAssignments; j++) {
                System.out.print("Enter the score for assignment " + (j + 1) + " for " + studentNames[i] + ": ");
                grades[i][j] = scanner.nextDouble();
                sum += grades[i][j];
            }
            averageScores[i] = sum / numAssignments;
        }

        System.out.println("\nStudent Grades:");
        System.out.println("Name\t\tAssignments\t\tAverage\t\tGrade");
        for (int i = 0; i < numStudents; i++) {
            System.out.print(studentNames[i] + "\t\t");
            for (int j = 0; j < numAssignments; j++) {
                System.out.print(grades[i][j] + "\t");
            }
            String letterGrade = getLetterGrade(averageScores[i]);
            System.out.println("\t" + averageScores[i] + "\t\t" + letterGrade);
        }

        findHighestAndLowestAverage(averageScores, studentNames);
        sortStudentsByAverage(studentNames, averageScores, grades);

        scanner.close();
    }

    private static String getLetterGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }


    private static void findHighestAndLowestAverage(double[] averageScores, String[] studentNames) {
        double highest = averageScores[0];
        double lowest = averageScores[0];
        String highestStudent = studentNames[0];
        String lowestStudent = studentNames[0];

        for (int i = 1; i < averageScores.length; i++) {
            if (averageScores[i] > highest) {
                highest = averageScores[i];
                highestStudent = studentNames[i];
            }
            if (averageScores[i] < lowest) {
                lowest = averageScores[i];
                lowestStudent = studentNames[i];
            }
        }

        System.out.println("\nHighest Average Score: " + highest + " by " + highestStudent);
        System.out.println("Lowest Average Score: " + lowest + " by " + lowestStudent);
    }

    private static void sortStudentsByAverage(String[] studentNames, double[] averageScores, double[][] grades) {
        for (int i = 0; i < averageScores.length - 1; i++) {
            for (int j = 0; j < averageScores.length - i - 1; j++) {
                if (averageScores[j] < averageScores[j + 1]) {
                    double tempAverage = averageScores[j];
                    averageScores[j] = averageScores[j + 1];
                    averageScores[j + 1] = tempAverage;

                    String tempName = studentNames[j];
                    studentNames[j] = studentNames[j + 1];
                    studentNames[j + 1] = tempName;

                    double[] tempGrades = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = tempGrades;
                }
            }
        }

        System.out.println("\nSorted Students by Average Score:");
        System.out.println("Name\t\tAverage Score");
        for (int i = 0; i < studentNames.length; i++) {
            System.out.println(studentNames[i] + "\t\t" + averageScores[i]);
        }
    }
}
