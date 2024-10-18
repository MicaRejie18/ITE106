import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentGradebookFileIO {
    public static void main(String[] args) {
        String inputFilePath = "student_data.txt";
        String outputFilePath = "student_grades.txt";

        List<String> studentData = readStudentDataFromFile(inputFilePath);
        List<String> studentGrades = processStudentData(studentData);

        writeStudentGradesToFile(outputFilePath, studentGrades);
        System.out.println("Student grades have been written to " + outputFilePath);
    }

    public static List<String> readStudentDataFromFile(String filePath) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return data;
    }

    public static List<String> processStudentData(List<String> data) {
        List<String> results = new ArrayList<>();
        results.add("Name              Quiz1 Quiz2 Homework1 Midterm Final Average Grade");

        for (String line : data) {
            String[] tokens = line.split(",");
            String name = tokens[0].trim();
            double totalScore = 0;
            for (int i = 1; i < tokens.length; i++) {
                totalScore += Double.parseDouble(tokens[i].trim());
            }
            double average = totalScore / (tokens.length - 1);
            char grade = calculateLetterGrade(average);
            results.add(String.format("%-17s %5s %5s %8s %7s %5s %7.2f %5c", name, tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], average, grade));
        }
        return results;
    }

    public static void writeStudentGradesToFile(String filePath, List<String> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : data) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
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
